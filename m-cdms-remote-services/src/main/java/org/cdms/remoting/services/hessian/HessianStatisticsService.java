package org.cdms.remoting.services.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.client.HessianRuntimeException;
import java.net.MalformedURLException;
import java.util.prefs.Preferences;
import org.cdms.shared.entities.InvoiceStatView;
import org.cdms.shared.remoting.ConfigService;
import org.cdms.shared.remoting.QueryPage;
import org.cdms.shared.remoting.StatisticsService;
import org.cdms.shared.remoting.UserInfo;
import org.cdms.shared.remoting.exception.RemoteConnectionException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbPreferences;

/**
 *
 * @author V. Shyshkin
 */
public  abstract class HessianStatisticsService implements StatisticsService {
    
    protected abstract Class getServiceClass();

    private StatisticsService getService() throws MalformedURLException {
        
        UserInfo info = ((ConfigService)Lookup.getDefault().lookup(ConfigService.class)).getConfig();
        HessianProxyFactory factory = new HessianProxyFactory();
        //HessianProxyFactory factory = (HessianProxyFactory)info.getProxyFactory();
        Preferences node = NbPreferences.root();
        String serverName = node.get("server.name", "localhost");
        int port = node.getInt("server.port", 8080);
        
        String url = "http://" + serverName + ":" + port + HessianEntityService.SERVER_PATH + getServiceClass().getSimpleName();
//            factory.setUser(userName);
//            factory.setPassword(password);
        factory.setUser(info.getUserName());
        factory.setPassword(info.getTicket()); // TODO in production
        return (StatisticsService) factory.create(getServiceClass(), url);
    }

    @Override
    public QueryPage<InvoiceStatView> requestInvoice(QueryPage<InvoiceStatView> queryPage) {
        try {
            return getService().requestInvoice(queryPage);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch(HessianRuntimeException hre) {
            throwHesianTranslated(hre, "requestInvoice");
        }
        return null;
        
    }


    public void throwHesianTranslated(Exception e,String methodName) {
        RemoteConnectionException re = new RemoteConnectionException(e.getMessage());
        re.setOriginalClassName(e.getClass().getName());
        re.setEntityName("Statistics");
        re.setServiceName("HessianStatisticsService");
        re.setServiceMethodName(methodName);
        if ( re.getCause() != null ) {
            re.setCauseClassName(e.getCause().getClass().getName());
            re.setCauseMessage(e.getCause().getMessage());
        } else {
            re.setCauseMessage(e.getMessage());
        }
        
        throw re;
    }
    
}
