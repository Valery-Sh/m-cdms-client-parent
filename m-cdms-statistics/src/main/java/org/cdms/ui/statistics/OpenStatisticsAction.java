/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdms.ui.statistics;

import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import org.cdms.ui.common.AbstractOpenTopComponentAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "Applications",
id = "org.cdms.ui.statictics.OpenStatisticsAction")
@ActionRegistration(
    iconBase = "org/cdms/ui/statistics/statistics16x16.png",
displayName = "#CTL_OpenStatisticsAction")
@ActionReference(path = "Menu/Applications", position = 2933)
@Messages("CTL_OpenStatisticsAction=Statistics")
public final class OpenStatisticsAction extends AbstractOpenTopComponentAction {    
   
   public OpenStatisticsAction() {
       super();
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        openTopComponent("statisticsTopComponent");
    }   

    @Override
    public JMenuItem getMenuPresenter() {
        return getMenuPresenter(NbBundle.getMessage(OpenStatisticsAction.class, "CTL_OpenStatisticsAction"), 
                "org/cdms/ui/statistics/statistics16x16.png", 
                "view statistics");
    }


}
