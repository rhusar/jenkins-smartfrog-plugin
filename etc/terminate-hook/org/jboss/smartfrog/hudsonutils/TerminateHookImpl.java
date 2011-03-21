/*    */ package org.jboss.smartfrog.hudsonutils;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.rmi.Remote;
/*    */ import java.rmi.RemoteException;
/*    */ import org.smartfrog.sfcore.common.SmartFrogException;
/*    */ import org.smartfrog.sfcore.compound.CompoundImpl;
/*    */ import org.smartfrog.sfcore.logging.LogSF;
/*    */ import org.smartfrog.sfcore.prim.Prim;
/*    */ import org.smartfrog.sfcore.prim.PrimHook;
/*    */ import org.smartfrog.sfcore.prim.PrimHookSet;
/*    */ import org.smartfrog.sfcore.prim.TerminationRecord;
/*    */ 
/*    */ public class TerminateHookImpl extends CompoundImpl
/*    */   implements TerminateHook, Remote, PrimHook
/*    */ {
/*    */   public TerminateHookImpl()
/*    */     throws RemoteException
/*    */   {
/*    */   }
/*    */ 
/*    */   public synchronized void sfDeploy()
/*    */     throws SmartFrogException, RemoteException
/*    */   {
/* 32 */     super.sfDeploy();
/*    */ 
/* 34 */     sfTerminateWithHooks.addHook(this);
/*    */   }
/*    */ 
/*    */   public synchronized void sfStart()
/*    */     throws SmartFrogException, RemoteException
/*    */   {
/* 44 */     super.sfStart();
/*    */   }
/*    */ 
/*    */   public synchronized void sfTerminateWith(TerminationRecord r)
/*    */   {
/*    */     try
/*    */     {
/* 54 */       sfTerminateWithHooks.removeHook(this);
/*    */     } catch (Exception e) {
/* 56 */       System.out.println(" Couldn't remove terminate all hooks. ");
/*    */     }
/*    */ 
/* 59 */     super.sfTerminateWith(r);
/*    */   }
/*    */ 
/*    */   public void sfHookAction(Prim prim, TerminationRecord terminationRecord) throws SmartFrogException {
/*    */     try {
/* 64 */       System.out.println("[TerminateHook] Component terminating: [" + prim.sfCompleteName() + "]. Termination type: " + (terminationRecord.isNormal() ? "[NORMAL]" : "[ABNORMAL]"));
/*    */     }
/*    */     catch (RemoteException re) {
/* 67 */       sfLog().error("Could not get component name.", re);
/*    */     }
/*    */   }
/*    */ }

/* Location:           /home/mnovak/tmp/terminate-hook/
 * Qualified Name:     org.jboss.smartfrog.hudsonutils.TerminateHookImpl
 * JD-Core Version:    0.6.0
 */