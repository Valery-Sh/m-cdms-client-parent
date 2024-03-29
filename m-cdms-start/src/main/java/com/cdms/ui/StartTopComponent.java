
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdms.ui;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.cdms.ui//Start//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "StartTopComponent",

persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "com.cdms.ui.StartTopComponent")
@ActionReference(path = "Menu/Help" )
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_StartAction",
preferredID = "StartTopComponent")

@Messages({
    "CTL_StartAction=Start",
    "CTL_StartTopComponent=Start Window",
    "HINT_StartTopComponent=This is a Start window"
})
public final class StartTopComponent extends TopComponent {

    public StartTopComponent() {
        initComponents();
        
        setName(Bundle.CTL_StartTopComponent());
        setToolTipText(Bundle.HINT_StartTopComponent());
        // ?? May be putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applicationStartPanel1 = new com.cdms.ui.ApplicationStartPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(applicationStartPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(applicationStartPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        applicationStartPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(StartTopComponent.class, "StartTopComponent.applicationStartPanel1.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.cdms.ui.ApplicationStartPanel applicationStartPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
