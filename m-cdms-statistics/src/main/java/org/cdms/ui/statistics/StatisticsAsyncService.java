package org.cdms.ui.statistics;

import org.cdms.remoting.services.InvoiceStatisticsServiceProvider;
import org.cdms.shared.entities.InvoiceStatView;
import org.cdms.shared.remoting.QueryPage;
import org.cdms.shared.remoting.StatisticsService;
import org.cdms.ui.common.AsyncServiceProcessor;
import org.openide.util.TaskListener;

/**
 *
 * @author V. Shyshkin
 */
public class StatisticsAsyncService {
    
    protected AsyncServiceProcessor processor;
    
    
    
    public StatisticsService getStatisticsService() {
        //return (Lookup.getDefault().lookup(InvoiceStatisticsServiceProvider.class)).getInstance();
        return InvoiceStatisticsServiceProvider.getDefault().getInstance();        
    }

    public void requestInvoice(TaskListener taskListener, final QueryPage<InvoiceStatView> queryPage) {
        String msg = "Invoice statistics ... ";// + queryPage.getEntityAsExample().getClass().getSimpleName() + "s by Filter...";
        processor = new AsyncServiceProcessor(msg) {
            @Override
            public Object perform() {
                return getStatisticsService().requestInvoice(queryPage); // TODO paging                
            }
        };
        
        processor.run(taskListener);
    }

    
    public Object getResult() {
        return processor.getResult();
    }
    
}
