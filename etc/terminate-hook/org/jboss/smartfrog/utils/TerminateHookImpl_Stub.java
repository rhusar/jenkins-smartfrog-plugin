package org.jboss.smartfrog.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import java.rmi.MarshalException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.rmi.UnmarshalException;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteStub;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.smartfrog.sfcore.common.Context;
import org.smartfrog.sfcore.common.RemoteTags;
import org.smartfrog.sfcore.common.RemoteTagsComponent;
import org.smartfrog.sfcore.common.SmartFrogDeploymentException;
import org.smartfrog.sfcore.common.SmartFrogException;
import org.smartfrog.sfcore.common.SmartFrogLivenessException;
import org.smartfrog.sfcore.common.SmartFrogResolutionException;
import org.smartfrog.sfcore.common.SmartFrogRuntimeException;
import org.smartfrog.sfcore.componentdescription.ComponentDescription;
import org.smartfrog.sfcore.compound.Compound;
import org.smartfrog.sfcore.prim.ChildMinder;
import org.smartfrog.sfcore.prim.Diagnostics;
import org.smartfrog.sfcore.prim.Dump;
import org.smartfrog.sfcore.prim.Liveness;
import org.smartfrog.sfcore.prim.Prim;
import org.smartfrog.sfcore.prim.TerminationRecord;
import org.smartfrog.sfcore.prim.Update;
import org.smartfrog.sfcore.reference.Reference;
import org.smartfrog.sfcore.reference.RemoteReferenceResolver;
import org.smartfrog.sfcore.reference.RemoteReferenceResolverHelper;

public final class TerminateHookImpl_Stub extends RemoteStub
  implements TerminateHook, Remote, Compound, Prim
{
  private static final Operation[] operations = { new Operation("void sfAbandonUpdate()"), new Operation("java.lang.Object sfAddAttribute(java.lang.Object, java.lang.Object)"), new Operation("void sfAddChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("void sfAddTag(java.lang.Object, java.lang.String)"), new Operation("void sfAddTag(java.lang.String)"), new Operation("void sfAddTags(java.lang.Object, java.util.Set)"), new Operation("void sfAddTags(java.util.Set)"), new Operation("java.lang.Object sfAttributeKeyFor(java.lang.Object)"), new Operation("java.util.Iterator sfAttributes()"), new Operation("java.util.Enumeration sfChildren()"), new Operation("org.smartfrog.sfcore.reference.Reference sfCompleteName()"), new Operation("boolean sfContainsAttribute(java.lang.Object)"), new Operation("boolean sfContainsChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("boolean sfContainsTag(java.lang.Object, java.lang.String)"), new Operation("boolean sfContainsTag(java.lang.String)"), new Operation("boolean sfContainsValue(java.lang.Object)"), new Operation("org.smartfrog.sfcore.common.Context sfContext()"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewApp(java.lang.String, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewChild(java.lang.Object, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewChild(java.lang.Object, org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("void sfDeploy()"), new Operation("org.smartfrog.sfcore.prim.Prim sfDeployComponentDescription(java.lang.Object, org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("void sfDeployWith(org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.common.Context)"), new Operation("java.net.InetAddress sfDeployedHost()"), new Operation("java.lang.String sfDeployedProcessName()"), new Operation("void sfDetach()"), new Operation("void sfDetachAndTerminate(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfDiagnosticsReport()"), new Operation("void sfDumpState(org.smartfrog.sfcore.prim.Dump)"), new Operation("java.util.Set sfGetTags()"), new Operation("java.util.Set sfGetTags(java.lang.Object)"), new Operation("boolean sfIsDeployed()"), new Operation("boolean sfIsStarted()"), new Operation("boolean sfIsTerminated()"), new Operation("boolean sfIsTerminating()"), new Operation("org.smartfrog.sfcore.prim.Prim sfParent()"), new Operation("void sfParentageChanged()"), new Operation("void sfPing(java.lang.Object)"), new Operation("void sfPrepareUpdate()"), new Operation("java.lang.Object sfRemoveAttribute(java.lang.Object)"), new Operation("boolean sfRemoveChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("void sfRemoveTag(java.lang.Object, java.lang.String)"), new Operation("void sfRemoveTag(java.lang.String)"), new Operation("void sfRemoveTags(java.lang.Object, java.util.Set)"), new Operation("void sfRemoveTags(java.util.Set)"), new Operation("java.lang.Object sfReplaceAttribute(java.lang.Object, java.lang.Object)"), new Operation("java.lang.Object sfResolve(java.lang.String)"), new Operation("double sfResolve(java.lang.String, double, java.lang.Double, java.lang.Double, boolean)"), new Operation("double sfResolve(java.lang.String, double, boolean)"), new Operation("float sfResolve(java.lang.String, float, java.lang.Float, java.lang.Float, boolean)"), new Operation("float sfResolve(java.lang.String, float, boolean)"), new Operation("int sfResolve(java.lang.String, int, java.lang.Integer, java.lang.Integer, boolean)"), new Operation("int sfResolve(java.lang.String, int, boolean)"), new Operation("long sfResolve(java.lang.String, long, java.lang.Long, java.lang.Long, boolean)"), new Operation("long sfResolve(java.lang.String, long, boolean)"), new Operation("java.io.File sfResolve(java.lang.String, java.io.File, boolean)"), new Operation("java.lang.Object sfResolve(java.lang.String, java.lang.Object, boolean)"), new Operation("java.lang.String sfResolve(java.lang.String, java.lang.String, boolean)"), new Operation("java.net.InetAddress sfResolve(java.lang.String, java.net.InetAddress, boolean)"), new Operation("java.net.URL sfResolve(java.lang.String, java.net.URL, boolean)"), new Operation("java.util.Vector sfResolve(java.lang.String, java.util.Vector, boolean)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfResolve(java.lang.String, org.smartfrog.sfcore.componentdescription.ComponentDescription, boolean)"), new Operation("org.smartfrog.sfcore.compound.Compound sfResolve(java.lang.String, org.smartfrog.sfcore.compound.Compound, boolean)"), new Operation("org.smartfrog.sfcore.prim.Prim sfResolve(java.lang.String, org.smartfrog.sfcore.prim.Prim, boolean)"), new Operation("org.smartfrog.sfcore.reference.Reference sfResolve(java.lang.String, org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("java.lang.Object sfResolve(java.lang.String, boolean)"), new Operation("boolean sfResolve(java.lang.String, boolean, boolean)"), new Operation("java.lang.String sfResolve(java.lang.String, java.lang.String[], boolean)[]"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference)"), new Operation("double sfResolve(org.smartfrog.sfcore.reference.Reference, double, java.lang.Double, java.lang.Double, boolean)"), new Operation("double sfResolve(org.smartfrog.sfcore.reference.Reference, double, boolean)"), new Operation("float sfResolve(org.smartfrog.sfcore.reference.Reference, float, java.lang.Float, java.lang.Float, boolean)"), new Operation("float sfResolve(org.smartfrog.sfcore.reference.Reference, float, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, int)"), new Operation("int sfResolve(org.smartfrog.sfcore.reference.Reference, int, java.lang.Integer, java.lang.Integer, boolean)"), new Operation("int sfResolve(org.smartfrog.sfcore.reference.Reference, int, boolean)"), new Operation("long sfResolve(org.smartfrog.sfcore.reference.Reference, long, java.lang.Long, java.lang.Long, boolean)"), new Operation("long sfResolve(org.smartfrog.sfcore.reference.Reference, long, boolean)"), new Operation("java.io.File sfResolve(org.smartfrog.sfcore.reference.Reference, java.io.File, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.Object, boolean)"), new Operation("java.lang.String sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.String, boolean)"), new Operation("java.net.InetAddress sfResolve(org.smartfrog.sfcore.reference.Reference, java.net.InetAddress, boolean)"), new Operation("java.net.URL sfResolve(org.smartfrog.sfcore.reference.Reference, java.net.URL, boolean)"), new Operation("java.util.Vector sfResolve(org.smartfrog.sfcore.reference.Reference, java.util.Vector, boolean)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.componentdescription.ComponentDescription, boolean)"), new Operation("org.smartfrog.sfcore.compound.Compound sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.compound.Compound, boolean)"), new Operation("org.smartfrog.sfcore.prim.Prim sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.prim.Prim, boolean)"), new Operation("org.smartfrog.sfcore.reference.Reference sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("boolean sfResolve(org.smartfrog.sfcore.reference.Reference, boolean, boolean)"), new Operation("java.lang.String sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.String[], boolean)[]"), new Operation("java.lang.Object sfResolveHere(java.lang.Object)"), new Operation("java.lang.Object sfResolveHere(java.lang.Object, boolean)"), new Operation("java.lang.Object sfResolveHereNonlocal(java.lang.Object, boolean)"), new Operation("java.lang.Object sfResolveParent()"), new Operation("java.lang.Object sfResolveWithParser(java.lang.String)"), new Operation("void sfSetTags(java.lang.Object, java.util.Set)"), new Operation("void sfSetTags(java.util.Set)"), new Operation("void sfStart()"), new Operation("void sfTerminate(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("void sfTerminateQuietlyWith(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("void sfTerminatedWith(org.smartfrog.sfcore.prim.TerminationRecord, org.smartfrog.sfcore.prim.Prim)"), new Operation("void sfUpdate()"), new Operation("void sfUpdateComponent(org.smartfrog.sfcore.componentdescription.ComponentDescription)"), new Operation("void sfUpdateDeploy()"), new Operation("void sfUpdateStart()"), new Operation("boolean sfUpdateWith(org.smartfrog.sfcore.common.Context)"), new Operation("boolean sfValid()"), new Operation("java.util.Iterator sfValues()") };
  private static final long interfaceHash = 95256091449878667L;
  private static final long serialVersionUID = 2L;
  private static boolean useNewInvoke;
  private static Method $method_sfAbandonUpdate_0;
  private static Method $method_sfAddAttribute_1;
  private static Method $method_sfAddChild_2;
  private static Method $method_sfAddTag_3;
  private static Method $method_sfAddTag_4;
  private static Method $method_sfAddTags_5;
  private static Method $method_sfAddTags_6;
  private static Method $method_sfAttributeKeyFor_7;
  private static Method $method_sfAttributes_8;
  private static Method $method_sfChildren_9;
  private static Method $method_sfCompleteName_10;
  private static Method $method_sfContainsAttribute_11;
  private static Method $method_sfContainsChild_12;
  private static Method $method_sfContainsTag_13;
  private static Method $method_sfContainsTag_14;
  private static Method $method_sfContainsValue_15;
  private static Method $method_sfContext_16;
  private static Method $method_sfCreateNewApp_17;
  private static Method $method_sfCreateNewChild_18;
  private static Method $method_sfCreateNewChild_19;
  private static Method $method_sfDeploy_20;
  private static Method $method_sfDeployComponentDescription_21;
  private static Method $method_sfDeployWith_22;
  private static Method $method_sfDeployedHost_23;
  private static Method $method_sfDeployedProcessName_24;
  private static Method $method_sfDetach_25;
  private static Method $method_sfDetachAndTerminate_26;
  private static Method $method_sfDiagnosticsReport_27;
  private static Method $method_sfDumpState_28;
  private static Method $method_sfGetTags_29;
  private static Method $method_sfGetTags_30;
  private static Method $method_sfIsDeployed_31;
  private static Method $method_sfIsStarted_32;
  private static Method $method_sfIsTerminated_33;
  private static Method $method_sfIsTerminating_34;
  private static Method $method_sfParent_35;
  private static Method $method_sfParentageChanged_36;
  private static Method $method_sfPing_37;
  private static Method $method_sfPrepareUpdate_38;
  private static Method $method_sfRemoveAttribute_39;
  private static Method $method_sfRemoveChild_40;
  private static Method $method_sfRemoveTag_41;
  private static Method $method_sfRemoveTag_42;
  private static Method $method_sfRemoveTags_43;
  private static Method $method_sfRemoveTags_44;
  private static Method $method_sfReplaceAttribute_45;
  private static Method $method_sfResolve_46;
  private static Method $method_sfResolve_47;
  private static Method $method_sfResolve_48;
  private static Method $method_sfResolve_49;
  private static Method $method_sfResolve_50;
  private static Method $method_sfResolve_51;
  private static Method $method_sfResolve_52;
  private static Method $method_sfResolve_53;
  private static Method $method_sfResolve_54;
  private static Method $method_sfResolve_55;
  private static Method $method_sfResolve_56;
  private static Method $method_sfResolve_57;
  private static Method $method_sfResolve_58;
  private static Method $method_sfResolve_59;
  private static Method $method_sfResolve_60;
  private static Method $method_sfResolve_61;
  private static Method $method_sfResolve_62;
  private static Method $method_sfResolve_63;
  private static Method $method_sfResolve_64;
  private static Method $method_sfResolve_65;
  private static Method $method_sfResolve_66;
  private static Method $method_sfResolve_67;
  private static Method $method_sfResolve_68;
  private static Method $method_sfResolve_69;
  private static Method $method_sfResolve_70;
  private static Method $method_sfResolve_71;
  private static Method $method_sfResolve_72;
  private static Method $method_sfResolve_73;
  private static Method $method_sfResolve_74;
  private static Method $method_sfResolve_75;
  private static Method $method_sfResolve_76;
  private static Method $method_sfResolve_77;
  private static Method $method_sfResolve_78;
  private static Method $method_sfResolve_79;
  private static Method $method_sfResolve_80;
  private static Method $method_sfResolve_81;
  private static Method $method_sfResolve_82;
  private static Method $method_sfResolve_83;
  private static Method $method_sfResolve_84;
  private static Method $method_sfResolve_85;
  private static Method $method_sfResolve_86;
  private static Method $method_sfResolve_87;
  private static Method $method_sfResolve_88;
  private static Method $method_sfResolve_89;
  private static Method $method_sfResolve_90;
  private static Method $method_sfResolveHere_91;
  private static Method $method_sfResolveHere_92;
  private static Method $method_sfResolveHereNonlocal_93;
  private static Method $method_sfResolveParent_94;
  private static Method $method_sfResolveWithParser_95;
  private static Method $method_sfSetTags_96;
  private static Method $method_sfSetTags_97;
  private static Method $method_sfStart_98;
  private static Method $method_sfTerminate_99;
  private static Method $method_sfTerminateQuietlyWith_100;
  private static Method $method_sfTerminatedWith_101;
  private static Method $method_sfUpdate_102;
  private static Method $method_sfUpdateComponent_103;
  private static Method $method_sfUpdateDeploy_104;
  private static Method $method_sfUpdateStart_105;
  private static Method $method_sfUpdateWith_106;
  private static Method $method_sfValid_107;
  private static Method $method_sfValues_108;

  static
  {
    try
    {
      RemoteRef.class.getMethod("invoke", new Class[] { Remote.class, Method.class, new Object[0].getClass(), Long.TYPE });
      useNewInvoke = true;
      $method_sfAbandonUpdate_0 = Update.class.getMethod("sfAbandonUpdate", new Class[0]);
      $method_sfAddAttribute_1 = Prim.class.getMethod("sfAddAttribute", new Class[] { Object.class, Object.class });
      $method_sfAddChild_2 = ChildMinder.class.getMethod("sfAddChild", new Class[] { Liveness.class });
      $method_sfAddTag_3 = RemoteTags.class.getMethod("sfAddTag", new Class[] { Object.class, String.class });
      $method_sfAddTag_4 = RemoteTagsComponent.class.getMethod("sfAddTag", new Class[] { String.class });
      $method_sfAddTags_5 = RemoteTags.class.getMethod("sfAddTags", new Class[] { Object.class, Set.class });
      $method_sfAddTags_6 = RemoteTagsComponent.class.getMethod("sfAddTags", new Class[] { Set.class });
      $method_sfAttributeKeyFor_7 = Prim.class.getMethod("sfAttributeKeyFor", new Class[] { Object.class });
      $method_sfAttributes_8 = Prim.class.getMethod("sfAttributes", new Class[0]);
      $method_sfChildren_9 = ChildMinder.class.getMethod("sfChildren", new Class[0]);
      $method_sfCompleteName_10 = Prim.class.getMethod("sfCompleteName", new Class[0]);
      $method_sfContainsAttribute_11 = Prim.class.getMethod("sfContainsAttribute", new Class[] { Object.class });
      $method_sfContainsChild_12 = ChildMinder.class.getMethod("sfContainsChild", new Class[] { Liveness.class });
      $method_sfContainsTag_13 = RemoteTags.class.getMethod("sfContainsTag", new Class[] { Object.class, String.class });
      $method_sfContainsTag_14 = RemoteTagsComponent.class.getMethod("sfContainsTag", new Class[] { String.class });
      $method_sfContainsValue_15 = Prim.class.getMethod("sfContainsValue", new Class[] { Object.class });
      $method_sfContext_16 = Prim.class.getMethod("sfContext", new Class[0]);
      $method_sfCreateNewApp_17 = Compound.class.getMethod("sfCreateNewApp", new Class[] { String.class, ComponentDescription.class, Context.class });
      $method_sfCreateNewChild_18 = Compound.class.getMethod("sfCreateNewChild", new Class[] { Object.class, ComponentDescription.class, Context.class });
      $method_sfCreateNewChild_19 = Compound.class.getMethod("sfCreateNewChild", new Class[] { Object.class, Prim.class, ComponentDescription.class, Context.class });
      $method_sfDeploy_20 = Prim.class.getMethod("sfDeploy", new Class[0]);
      $method_sfDeployComponentDescription_21 = Compound.class.getMethod("sfDeployComponentDescription", new Class[] { Object.class, Prim.class, ComponentDescription.class, Context.class });
      $method_sfDeployWith_22 = Prim.class.getMethod("sfDeployWith", new Class[] { Prim.class, Context.class });
      $method_sfDeployedHost_23 = Prim.class.getMethod("sfDeployedHost", new Class[0]);
      $method_sfDeployedProcessName_24 = Prim.class.getMethod("sfDeployedProcessName", new Class[0]);
      $method_sfDetach_25 = Prim.class.getMethod("sfDetach", new Class[0]);
      $method_sfDetachAndTerminate_26 = Prim.class.getMethod("sfDetachAndTerminate", new Class[] { TerminationRecord.class });
      $method_sfDiagnosticsReport_27 = Diagnostics.class.getMethod("sfDiagnosticsReport", new Class[0]);
      $method_sfDumpState_28 = Prim.class.getMethod("sfDumpState", new Class[] { Dump.class });
      $method_sfGetTags_29 = RemoteTagsComponent.class.getMethod("sfGetTags", new Class[0]);
      $method_sfGetTags_30 = RemoteTags.class.getMethod("sfGetTags", new Class[] { Object.class });
      $method_sfIsDeployed_31 = Prim.class.getMethod("sfIsDeployed", new Class[0]);
      $method_sfIsStarted_32 = Prim.class.getMethod("sfIsStarted", new Class[0]);
      $method_sfIsTerminated_33 = Prim.class.getMethod("sfIsTerminated", new Class[0]);
      $method_sfIsTerminating_34 = Prim.class.getMethod("sfIsTerminating", new Class[0]);
      $method_sfParent_35 = Prim.class.getMethod("sfParent", new Class[0]);
      $method_sfParentageChanged_36 = Prim.class.getMethod("sfParentageChanged", new Class[0]);
      $method_sfPing_37 = Liveness.class.getMethod("sfPing", new Class[] { Object.class });
      $method_sfPrepareUpdate_38 = Update.class.getMethod("sfPrepareUpdate", new Class[0]);
      $method_sfRemoveAttribute_39 = Prim.class.getMethod("sfRemoveAttribute", new Class[] { Object.class });
      $method_sfRemoveChild_40 = ChildMinder.class.getMethod("sfRemoveChild", new Class[] { Liveness.class });
      $method_sfRemoveTag_41 = RemoteTags.class.getMethod("sfRemoveTag", new Class[] { Object.class, String.class });
      $method_sfRemoveTag_42 = RemoteTagsComponent.class.getMethod("sfRemoveTag", new Class[] { String.class });
      $method_sfRemoveTags_43 = RemoteTags.class.getMethod("sfRemoveTags", new Class[] { Object.class, Set.class });
      $method_sfRemoveTags_44 = RemoteTagsComponent.class.getMethod("sfRemoveTags", new Class[] { Set.class });
      $method_sfReplaceAttribute_45 = Prim.class.getMethod("sfReplaceAttribute", new Class[] { Object.class, Object.class });
      $method_sfResolve_46 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class });
      $method_sfResolve_47 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Double.TYPE, Double.class, Double.class, Boolean.TYPE });
      $method_sfResolve_48 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Double.TYPE, Boolean.TYPE });
      $method_sfResolve_49 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Float.TYPE, Float.class, Float.class, Boolean.TYPE });
      $method_sfResolve_50 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Float.TYPE, Boolean.TYPE });
      $method_sfResolve_51 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Integer.TYPE, Integer.class, Integer.class, Boolean.TYPE });
      $method_sfResolve_52 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      $method_sfResolve_53 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Long.TYPE, Long.class, Long.class, Boolean.TYPE });
      $method_sfResolve_54 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Long.TYPE, Boolean.TYPE });
      $method_sfResolve_55 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, File.class, Boolean.TYPE });
      $method_sfResolve_56 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Object.class, Boolean.TYPE });
      $method_sfResolve_57 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, String.class, Boolean.TYPE });
      $method_sfResolve_58 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, InetAddress.class, Boolean.TYPE });
      $method_sfResolve_59 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, URL.class, Boolean.TYPE });
      $method_sfResolve_60 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Vector.class, Boolean.TYPE });
      $method_sfResolve_61 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, ComponentDescription.class, Boolean.TYPE });
      $method_sfResolve_62 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Compound.class, Boolean.TYPE });
      $method_sfResolve_63 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Prim.class, Boolean.TYPE });
      $method_sfResolve_64 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Reference.class, Boolean.TYPE });
      $method_sfResolve_65 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Boolean.TYPE });
      $method_sfResolve_66 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, Boolean.TYPE, Boolean.TYPE });
      $method_sfResolve_67 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { String.class, new String[0].getClass(), Boolean.TYPE });
      $method_sfResolve_68 = RemoteReferenceResolver.class.getMethod("sfResolve", new Class[] { Reference.class });
      $method_sfResolve_69 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Double.TYPE, Double.class, Double.class, Boolean.TYPE });
      $method_sfResolve_70 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Double.TYPE, Boolean.TYPE });
      $method_sfResolve_71 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Float.TYPE, Float.class, Float.class, Boolean.TYPE });
      $method_sfResolve_72 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Float.TYPE, Boolean.TYPE });
      $method_sfResolve_73 = RemoteReferenceResolver.class.getMethod("sfResolve", new Class[] { Reference.class, Integer.TYPE });
      $method_sfResolve_74 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Integer.TYPE, Integer.class, Integer.class, Boolean.TYPE });
      $method_sfResolve_75 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Integer.TYPE, Boolean.TYPE });
      $method_sfResolve_76 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Long.TYPE, Long.class, Long.class, Boolean.TYPE });
      $method_sfResolve_77 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Long.TYPE, Boolean.TYPE });
      $method_sfResolve_78 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, File.class, Boolean.TYPE });
      $method_sfResolve_79 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Object.class, Boolean.TYPE });
      $method_sfResolve_80 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, String.class, Boolean.TYPE });
      $method_sfResolve_81 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, InetAddress.class, Boolean.TYPE });
      $method_sfResolve_82 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, URL.class, Boolean.TYPE });
      $method_sfResolve_83 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Vector.class, Boolean.TYPE });
      $method_sfResolve_84 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, ComponentDescription.class, Boolean.TYPE });
      $method_sfResolve_85 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Compound.class, Boolean.TYPE });
      $method_sfResolve_86 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Prim.class, Boolean.TYPE });
      $method_sfResolve_87 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Reference.class, Boolean.TYPE });
      $method_sfResolve_88 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Boolean.TYPE });
      $method_sfResolve_89 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, Boolean.TYPE, Boolean.TYPE });
      $method_sfResolve_90 = RemoteReferenceResolverHelper.class.getMethod("sfResolve", new Class[] { Reference.class, new String[0].getClass(), Boolean.TYPE });
      $method_sfResolveHere_91 = RemoteReferenceResolver.class.getMethod("sfResolveHere", new Class[] { Object.class });
      $method_sfResolveHere_92 = RemoteReferenceResolver.class.getMethod("sfResolveHere", new Class[] { Object.class, Boolean.TYPE });
      $method_sfResolveHereNonlocal_93 = RemoteReferenceResolver.class.getMethod("sfResolveHereNonlocal", new Class[] { Object.class, Boolean.TYPE });
      $method_sfResolveParent_94 = RemoteReferenceResolver.class.getMethod("sfResolveParent", new Class[0]);
      $method_sfResolveWithParser_95 = RemoteReferenceResolverHelper.class.getMethod("sfResolveWithParser", new Class[] { String.class });
      $method_sfSetTags_96 = RemoteTags.class.getMethod("sfSetTags", new Class[] { Object.class, Set.class });
      $method_sfSetTags_97 = RemoteTagsComponent.class.getMethod("sfSetTags", new Class[] { Set.class });
      $method_sfStart_98 = Prim.class.getMethod("sfStart", new Class[0]);
      $method_sfTerminate_99 = Prim.class.getMethod("sfTerminate", new Class[] { TerminationRecord.class });
      $method_sfTerminateQuietlyWith_100 = Prim.class.getMethod("sfTerminateQuietlyWith", new Class[] { TerminationRecord.class });
      $method_sfTerminatedWith_101 = Prim.class.getMethod("sfTerminatedWith", new Class[] { TerminationRecord.class, Prim.class });
      $method_sfUpdate_102 = Update.class.getMethod("sfUpdate", new Class[0]);
      $method_sfUpdateComponent_103 = Update.class.getMethod("sfUpdateComponent", new Class[] { ComponentDescription.class });
      $method_sfUpdateDeploy_104 = Update.class.getMethod("sfUpdateDeploy", new Class[0]);
      $method_sfUpdateStart_105 = Update.class.getMethod("sfUpdateStart", new Class[0]);
      $method_sfUpdateWith_106 = Update.class.getMethod("sfUpdateWith", new Class[] { Context.class });
      $method_sfValid_107 = Prim.class.getMethod("sfValid", new Class[0]);
      $method_sfValues_108 = Prim.class.getMethod("sfValues", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      useNewInvoke = false;
    }
  }

  public TerminateHookImpl_Stub()
  {
  }

  public TerminateHookImpl_Stub(RemoteRef paramRemoteRef)
  {
    super(paramRemoteRef);
  }

  public void sfAbandonUpdate()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAbandonUpdate_0, null, 8795384095142827219L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 0, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Object sfAddAttribute(Object paramObject1, Object paramObject2)
    throws SmartFrogRuntimeException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfAddAttribute_1, new Object[] { paramObject1, paramObject2 }, -752402149624012578L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 1, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject1);
        localObjectOutput.writeObject(paramObject2);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfAddChild(Liveness paramLiveness)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAddChild_2, new Object[] { paramLiveness }, -4988964723608828241L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 2, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramLiveness);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfAddTag(Object paramObject, String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAddTag_3, new Object[] { paramObject, paramString }, 5222344892867082436L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 3, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
          localObjectOutput.writeObject(paramString);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfAddTag(String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAddTag_4, new Object[] { paramString }, -5292244336360487324L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 4, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfAddTags(Object paramObject, Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAddTags_5, new Object[] { paramObject, paramSet }, -2482714145755934402L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 5, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfAddTags(Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfAddTags_6, new Object[] { paramSet }, -4250655186362973831L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 6, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Object sfAttributeKeyFor(Object paramObject)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfAttributeKeyFor_7, new Object[] { paramObject }, 917196947060357926L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 7, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Iterator sfAttributes()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfAttributes_8, null, -1120450218948359869L);
        return (Iterator)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 8, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Iterator localIterator;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localIterator = (Iterator)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localIterator;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Enumeration sfChildren()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfChildren_9, null, 2596040897270252721L);
        return (Enumeration)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 9, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Enumeration localEnumeration;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localEnumeration = (Enumeration)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localEnumeration;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Reference sfCompleteName()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfCompleteName_10, null, 3408786407923213136L);
        return (Reference)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 10, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Reference localReference;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localReference = (Reference)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localReference;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfContainsAttribute(Object paramObject)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContainsAttribute_11, new Object[] { paramObject }, 1321146646653078930L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 11, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfContainsChild(Liveness paramLiveness)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContainsChild_12, new Object[] { paramLiveness }, 340935267262165043L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 12, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramLiveness);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfContainsTag(Object paramObject, String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContainsTag_13, new Object[] { paramObject, paramString }, 8877310763612801403L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 13, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeObject(paramString);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfContainsTag(String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContainsTag_14, new Object[] { paramString }, -972907250431561467L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 14, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfContainsValue(Object paramObject)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContainsValue_15, new Object[] { paramObject }, 4680488223455576288L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 15, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Context sfContext()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfContext_16, null, -7894887194218774960L);
        return (Context)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 16, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Context localContext;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localContext = (Context)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localContext;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfCreateNewApp(String paramString, ComponentDescription paramComponentDescription, Context paramContext)
    throws RemoteException, SmartFrogDeploymentException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfCreateNewApp_17, new Object[] { paramString, paramComponentDescription, paramContext }, -5141359607666207938L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 17, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeObject(paramContext);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogDeploymentException localSmartFrogDeploymentException)
    {
      throw localSmartFrogDeploymentException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfCreateNewChild(Object paramObject, ComponentDescription paramComponentDescription, Context paramContext)
    throws RemoteException, SmartFrogDeploymentException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfCreateNewChild_18, new Object[] { paramObject, paramComponentDescription, paramContext }, -2248185910595993620L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 18, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeObject(paramContext);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogDeploymentException localSmartFrogDeploymentException)
    {
      throw localSmartFrogDeploymentException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfCreateNewChild(Object paramObject, Prim paramPrim, ComponentDescription paramComponentDescription, Context paramContext)
    throws RemoteException, SmartFrogDeploymentException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfCreateNewChild_19, new Object[] { paramObject, paramPrim, paramComponentDescription, paramContext }, 2826307050079361112L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 19, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeObject(paramPrim);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeObject(paramContext);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogDeploymentException localSmartFrogDeploymentException)
    {
      throw localSmartFrogDeploymentException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfDeploy()
    throws SmartFrogException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfDeploy_20, null, -1241400586518897420L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 20, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Prim sfDeployComponentDescription(Object paramObject, Prim paramPrim, ComponentDescription paramComponentDescription, Context paramContext)
    throws RemoteException, SmartFrogDeploymentException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfDeployComponentDescription_21, new Object[] { paramObject, paramPrim, paramComponentDescription, paramContext }, 7880370046911499052L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 21, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeObject(paramPrim);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeObject(paramContext);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogDeploymentException localSmartFrogDeploymentException)
    {
      throw localSmartFrogDeploymentException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfDeployWith(Prim paramPrim, Context paramContext)
    throws SmartFrogException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfDeployWith_22, new Object[] { paramPrim, paramContext }, 9013997983066141239L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 22, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramPrim);
          localObjectOutput.writeObject(paramContext);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public InetAddress sfDeployedHost()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfDeployedHost_23, null, -7925557175482833480L);
        return (InetAddress)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 23, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      InetAddress localInetAddress;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localInetAddress = (InetAddress)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localInetAddress;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public String sfDeployedProcessName()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfDeployedProcessName_24, null, -4296462462832072885L);
        return (String)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 24, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      String str;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        str = (String)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfDetach()
    throws SmartFrogException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfDetach_25, null, 7758033736977330935L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 25, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfDetachAndTerminate(TerminationRecord paramTerminationRecord)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfDetachAndTerminate_26, new Object[] { paramTerminationRecord }, -6011442031957692318L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 26, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramTerminationRecord);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public ComponentDescription sfDiagnosticsReport()
    throws SmartFrogException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfDiagnosticsReport_27, null, -4566415224652611266L);
        return (ComponentDescription)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 27, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      ComponentDescription localComponentDescription;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localComponentDescription = (ComponentDescription)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localComponentDescription;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfDumpState(Dump paramDump)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfDumpState_28, new Object[] { paramDump }, 3857681078674752434L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 28, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramDump);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Set sfGetTags()
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfGetTags_29, null, -4728466950669802219L);
        return (Set)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 29, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Set localSet;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localSet = (Set)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localSet;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Set sfGetTags(Object paramObject)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfGetTags_30, new Object[] { paramObject }, -7181563682722928331L);
        return (Set)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 30, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Set localSet;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localSet = (Set)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localSet;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfIsDeployed()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfIsDeployed_31, null, 3065601471260862548L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 31, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfIsStarted()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfIsStarted_32, null, 8410625712945957863L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 32, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfIsTerminated()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfIsTerminated_33, null, -7366981244650170840L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 33, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfIsTerminating()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfIsTerminating_34, null, -3399352455048426083L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 34, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfParent()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfParent_35, null, 7250859113734339498L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 35, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfParentageChanged()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfParentageChanged_36, null, -2354166004782981419L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 36, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfPing(Object paramObject)
    throws SmartFrogLivenessException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfPing_37, new Object[] { paramObject }, -85108778267501922L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 37, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogLivenessException localSmartFrogLivenessException)
    {
      throw localSmartFrogLivenessException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfPrepareUpdate()
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfPrepareUpdate_38, null, 4077533068082565925L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 38, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Object sfRemoveAttribute(Object paramObject)
    throws SmartFrogRuntimeException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfRemoveAttribute_39, new Object[] { paramObject }, -1342154479564100882L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 39, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfRemoveChild(Liveness paramLiveness)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfRemoveChild_40, new Object[] { paramLiveness }, 5342293696341823625L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 40, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramLiveness);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfRemoveTag(Object paramObject, String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfRemoveTag_41, new Object[] { paramObject, paramString }, 1928981356880354640L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 41, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
          localObjectOutput.writeObject(paramString);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfRemoveTag(String paramString)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfRemoveTag_42, new Object[] { paramString }, -3488580036607004553L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 42, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfRemoveTags(Object paramObject, Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfRemoveTags_43, new Object[] { paramObject, paramSet }, 8272091395929014291L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 43, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfRemoveTags(Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfRemoveTags_44, new Object[] { paramSet }, -2694742808033540268L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 44, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Object sfReplaceAttribute(Object paramObject1, Object paramObject2)
    throws SmartFrogRuntimeException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfReplaceAttribute_45, new Object[] { paramObject1, paramObject2 }, -4876583954089213984L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 45, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject1);
        localObjectOutput.writeObject(paramObject2);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(String paramString)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_46, new Object[] { paramString }, -2040128981771466702L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 46, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public double sfResolve(String paramString, double paramDouble, Double paramDouble1, Double paramDouble2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_47, new Object[] { paramString, new Double(paramDouble), paramDouble1, paramDouble2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -2534242255933564619L);
        return ((Double)localObject1).doubleValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 47, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeDouble(paramDouble);
        localObjectOutput.writeObject(paramDouble1);
        localObjectOutput.writeObject(paramDouble2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      double d;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        d = localObjectInput.readDouble();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return d;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public double sfResolve(String paramString, double paramDouble, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_48, new Object[] { paramString, new Double(paramDouble), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -2959792927313069734L);
        return ((Double)localObject1).doubleValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 48, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeDouble(paramDouble);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      double d;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        d = localObjectInput.readDouble();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return d;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public float sfResolve(String paramString, float paramFloat, Float paramFloat1, Float paramFloat2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_49, new Object[] { paramString, new Float(paramFloat), paramFloat1, paramFloat2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 1493379802569519239L);
        return ((Float)localObject1).floatValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 49, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeFloat(paramFloat);
        localObjectOutput.writeObject(paramFloat1);
        localObjectOutput.writeObject(paramFloat2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      float f;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        f = localObjectInput.readFloat();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return f;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public float sfResolve(String paramString, float paramFloat, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_50, new Object[] { paramString, new Float(paramFloat), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 4019130728270226649L);
        return ((Float)localObject1).floatValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 50, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeFloat(paramFloat);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      float f;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        f = localObjectInput.readFloat();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return f;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public int sfResolve(String paramString, int paramInt, Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_51, new Object[] { paramString, new Integer(paramInt), paramInteger1, paramInteger2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -5799916151847019931L);
        return ((Integer)localObject1).intValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 51, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeInt(paramInt);
        localObjectOutput.writeObject(paramInteger1);
        localObjectOutput.writeObject(paramInteger2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      int i;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        i = localObjectInput.readInt();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public int sfResolve(String paramString, int paramInt, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_52, new Object[] { paramString, new Integer(paramInt), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 7349824546392467963L);
        return ((Integer)localObject1).intValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 52, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeInt(paramInt);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      int i;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        i = localObjectInput.readInt();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public long sfResolve(String paramString, long paramLong, Long paramLong1, Long paramLong2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_53, new Object[] { paramString, new Long(paramLong), paramLong1, paramLong2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 3730994026809185944L);
        return ((Long)localObject1).longValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 53, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeLong(paramLong);
        localObjectOutput.writeObject(paramLong1);
        localObjectOutput.writeObject(paramLong2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      long l;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        l = localObjectInput.readLong();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public long sfResolve(String paramString, long paramLong, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_54, new Object[] { paramString, new Long(paramLong), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 8759690098061519321L);
        return ((Long)localObject1).longValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 54, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeLong(paramLong);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      long l;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        l = localObjectInput.readLong();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public File sfResolve(String paramString, File paramFile, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_55, new Object[] { paramString, paramFile, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 2896087789186144059L);
        return (File)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 55, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramFile);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      File localFile;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localFile = (File)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localFile;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(String paramString, Object paramObject, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_56, new Object[] { paramString, paramObject, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -5779905306292514673L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 56, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public String sfResolve(String paramString1, String paramString2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_57, new Object[] { paramString1, paramString2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -4287252325521442856L);
        return (String)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 57, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString1);
        localObjectOutput.writeObject(paramString2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      String str;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        str = (String)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public InetAddress sfResolve(String paramString, InetAddress paramInetAddress, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_58, new Object[] { paramString, paramInetAddress, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -6299349214437391645L);
        return (InetAddress)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 58, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramInetAddress);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      InetAddress localInetAddress;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localInetAddress = (InetAddress)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localInetAddress;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public URL sfResolve(String paramString, URL paramURL, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_59, new Object[] { paramString, paramURL, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 2641105198246316628L);
        return (URL)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 59, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramURL);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      URL localURL;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localURL = (URL)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localURL;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Vector sfResolve(String paramString, Vector paramVector, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_60, new Object[] { paramString, paramVector, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -7457079736029033266L);
        return (Vector)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 60, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramVector);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Vector localVector;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localVector = (Vector)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localVector;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public ComponentDescription sfResolve(String paramString, ComponentDescription paramComponentDescription, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_61, new Object[] { paramString, paramComponentDescription, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 278147432822912651L);
        return (ComponentDescription)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 61, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      ComponentDescription localComponentDescription;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localComponentDescription = (ComponentDescription)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localComponentDescription;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Compound sfResolve(String paramString, Compound paramCompound, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_62, new Object[] { paramString, paramCompound, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 1850765839868180218L);
        return (Compound)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 62, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramCompound);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Compound localCompound;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localCompound = (Compound)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localCompound;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfResolve(String paramString, Prim paramPrim, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_63, new Object[] { paramString, paramPrim, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 7620381415800346879L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 63, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramPrim);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Reference sfResolve(String paramString, Reference paramReference, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_64, new Object[] { paramString, paramReference, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -768190330923711433L);
        return (Reference)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 64, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Reference localReference;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localReference = (Reference)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localReference;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(String paramString, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_65, new Object[] { paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -5526512742624578005L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 65, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfResolve(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_66, new Object[] { paramString, paramBoolean1 ? Boolean.TRUE : Boolean.FALSE, paramBoolean2 ? Boolean.TRUE : Boolean.FALSE }, 3074056645332798871L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 66, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeBoolean(paramBoolean1);
        localObjectOutput.writeBoolean(paramBoolean2);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public String[] sfResolve(String paramString, String[] paramArrayOfString, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_67, new Object[] { paramString, paramArrayOfString, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -261531959238447026L);
        return (String[])localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 67, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramArrayOfString);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      String[] arrayOfString;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        arrayOfString = (String[])localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return arrayOfString;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(Reference paramReference)
    throws RemoteException, SmartFrogResolutionException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_68, new Object[] { paramReference }, 2723606398882502132L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 68, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public double sfResolve(Reference paramReference, double paramDouble, Double paramDouble1, Double paramDouble2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_69, new Object[] { paramReference, new Double(paramDouble), paramDouble1, paramDouble2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 1163355191403457648L);
        return ((Double)localObject1).doubleValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 69, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeDouble(paramDouble);
        localObjectOutput.writeObject(paramDouble1);
        localObjectOutput.writeObject(paramDouble2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      double d;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        d = localObjectInput.readDouble();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return d;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public double sfResolve(Reference paramReference, double paramDouble, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_70, new Object[] { paramReference, new Double(paramDouble), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 8228713188388847761L);
        return ((Double)localObject1).doubleValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 70, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeDouble(paramDouble);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      double d;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        d = localObjectInput.readDouble();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return d;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public float sfResolve(Reference paramReference, float paramFloat, Float paramFloat1, Float paramFloat2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_71, new Object[] { paramReference, new Float(paramFloat), paramFloat1, paramFloat2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -2101728420131928136L);
        return ((Float)localObject1).floatValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 71, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeFloat(paramFloat);
        localObjectOutput.writeObject(paramFloat1);
        localObjectOutput.writeObject(paramFloat2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      float f;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        f = localObjectInput.readFloat();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return f;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public float sfResolve(Reference paramReference, float paramFloat, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_72, new Object[] { paramReference, new Float(paramFloat), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 6354277681639172604L);
        return ((Float)localObject1).floatValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 72, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeFloat(paramFloat);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      float f;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        f = localObjectInput.readFloat();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return f;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(Reference paramReference, int paramInt)
    throws RemoteException, SmartFrogResolutionException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_73, new Object[] { paramReference, new Integer(paramInt) }, 5873372285246974544L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 73, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeInt(paramInt);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public int sfResolve(Reference paramReference, int paramInt, Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_74, new Object[] { paramReference, new Integer(paramInt), paramInteger1, paramInteger2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -7651263432762410531L);
        return ((Integer)localObject1).intValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 74, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeInt(paramInt);
        localObjectOutput.writeObject(paramInteger1);
        localObjectOutput.writeObject(paramInteger2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      int i;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        i = localObjectInput.readInt();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public int sfResolve(Reference paramReference, int paramInt, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_75, new Object[] { paramReference, new Integer(paramInt), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -297990108419193880L);
        return ((Integer)localObject1).intValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 75, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeInt(paramInt);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      int i;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        i = localObjectInput.readInt();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public long sfResolve(Reference paramReference, long paramLong, Long paramLong1, Long paramLong2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_76, new Object[] { paramReference, new Long(paramLong), paramLong1, paramLong2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -7496236984885271095L);
        return ((Long)localObject1).longValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 76, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeLong(paramLong);
        localObjectOutput.writeObject(paramLong1);
        localObjectOutput.writeObject(paramLong2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      long l;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        l = localObjectInput.readLong();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public long sfResolve(Reference paramReference, long paramLong, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_77, new Object[] { paramReference, new Long(paramLong), paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -5899506294683753348L);
        return ((Long)localObject1).longValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 77, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeLong(paramLong);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      long l;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        l = localObjectInput.readLong();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public File sfResolve(Reference paramReference, File paramFile, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_78, new Object[] { paramReference, paramFile, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -2079121628557084148L);
        return (File)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 78, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramFile);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      File localFile;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localFile = (File)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localFile;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(Reference paramReference, Object paramObject, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_79, new Object[] { paramReference, paramObject, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -3430394161774247870L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 79, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public String sfResolve(Reference paramReference, String paramString, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_80, new Object[] { paramReference, paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 2922238431955583955L);
        return (String)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 80, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      String str;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        str = (String)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public InetAddress sfResolve(Reference paramReference, InetAddress paramInetAddress, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_81, new Object[] { paramReference, paramInetAddress, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 4579525934675499763L);
        return (InetAddress)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 81, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramInetAddress);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      InetAddress localInetAddress;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localInetAddress = (InetAddress)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localInetAddress;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public URL sfResolve(Reference paramReference, URL paramURL, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_82, new Object[] { paramReference, paramURL, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 109120547210689151L);
        return (URL)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 82, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramURL);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      URL localURL;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localURL = (URL)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localURL;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Vector sfResolve(Reference paramReference, Vector paramVector, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_83, new Object[] { paramReference, paramVector, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -2984838881853226953L);
        return (Vector)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 83, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramVector);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Vector localVector;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localVector = (Vector)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localVector;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public ComponentDescription sfResolve(Reference paramReference, ComponentDescription paramComponentDescription, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_84, new Object[] { paramReference, paramComponentDescription, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 1041372419954209560L);
        return (ComponentDescription)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 84, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramComponentDescription);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      ComponentDescription localComponentDescription;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localComponentDescription = (ComponentDescription)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localComponentDescription;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Compound sfResolve(Reference paramReference, Compound paramCompound, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_85, new Object[] { paramReference, paramCompound, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -1662604997403230368L);
        return (Compound)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 85, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramCompound);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Compound localCompound;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localCompound = (Compound)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localCompound;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Prim sfResolve(Reference paramReference, Prim paramPrim, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_86, new Object[] { paramReference, paramPrim, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -1672544750669587866L);
        return (Prim)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 86, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramPrim);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Prim localPrim;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localPrim = (Prim)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localPrim;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Reference sfResolve(Reference paramReference1, Reference paramReference2, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_87, new Object[] { paramReference1, paramReference2, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -648918243307555357L);
        return (Reference)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 87, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference1);
        localObjectOutput.writeObject(paramReference2);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Reference localReference;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localReference = (Reference)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localReference;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolve(Reference paramReference, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_88, new Object[] { paramReference, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -7284746406181901887L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 88, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfResolve(Reference paramReference, boolean paramBoolean1, boolean paramBoolean2)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_89, new Object[] { paramReference, paramBoolean1 ? Boolean.TRUE : Boolean.FALSE, paramBoolean2 ? Boolean.TRUE : Boolean.FALSE }, 2279481227005775614L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 89, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeBoolean(paramBoolean1);
        localObjectOutput.writeBoolean(paramBoolean2);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public String[] sfResolve(Reference paramReference, String[] paramArrayOfString, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolve_90, new Object[] { paramReference, paramArrayOfString, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, -7253456114976696912L);
        return (String[])localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 90, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramReference);
        localObjectOutput.writeObject(paramArrayOfString);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      String[] arrayOfString;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        arrayOfString = (String[])localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return arrayOfString;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolveHere(Object paramObject)
    throws RemoteException, SmartFrogResolutionException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolveHere_91, new Object[] { paramObject }, 6973307674343303035L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 91, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolveHere(Object paramObject, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolveHere_92, new Object[] { paramObject, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 1780962583192600160L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 92, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolveHereNonlocal(Object paramObject, boolean paramBoolean)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolveHereNonlocal_93, new Object[] { paramObject, paramBoolean ? Boolean.TRUE : Boolean.FALSE }, 2760027684983779767L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 93, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramObject);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolveParent()
    throws RemoteException, SmartFrogResolutionException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolveParent_94, null, 2630687939934197351L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 94, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Object sfResolveWithParser(String paramString)
    throws SmartFrogResolutionException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfResolveWithParser_95, new Object[] { paramString }, -1587196096168695961L);
        return localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 95, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Object localObject2;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localObject2 = localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogResolutionException localSmartFrogResolutionException)
    {
      throw localSmartFrogResolutionException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public void sfSetTags(Object paramObject, Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfSetTags_96, new Object[] { paramObject, paramSet }, 9065223492846062597L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 96, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramObject);
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfSetTags(Set paramSet)
    throws RemoteException, SmartFrogRuntimeException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfSetTags_97, new Object[] { paramSet }, 2341858194978505393L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 97, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramSet);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogRuntimeException localSmartFrogRuntimeException)
    {
      throw localSmartFrogRuntimeException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfStart()
    throws SmartFrogException, RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfStart_98, null, 5760549645760591948L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 98, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfTerminate(TerminationRecord paramTerminationRecord)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfTerminate_99, new Object[] { paramTerminationRecord }, -1353479667122505023L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 99, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramTerminationRecord);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfTerminateQuietlyWith(TerminationRecord paramTerminationRecord)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfTerminateQuietlyWith_100, new Object[] { paramTerminationRecord }, 5849629192947399252L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 100, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramTerminationRecord);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfTerminatedWith(TerminationRecord paramTerminationRecord, Prim paramPrim)
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfTerminatedWith_101, new Object[] { paramTerminationRecord, paramPrim }, 2893824888564780976L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 101, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramTerminationRecord);
          localObjectOutput.writeObject(paramPrim);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfUpdate()
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfUpdate_102, null, -4763275676445796821L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 102, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfUpdateComponent(ComponentDescription paramComponentDescription)
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfUpdateComponent_103, new Object[] { paramComponentDescription }, 7167319618838809995L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 103, 95256091449878667L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramComponentDescription);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfUpdateDeploy()
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfUpdateDeploy_104, null, -471903359761229907L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 104, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void sfUpdateStart()
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_sfUpdateStart_105, null, 3210047280676871217L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 105, 95256091449878667L);
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public boolean sfUpdateWith(Context paramContext)
    throws RemoteException, SmartFrogException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfUpdateWith_106, new Object[] { paramContext }, -4839307845624642844L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 106, 95256091449878667L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramContext);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (SmartFrogException localSmartFrogException)
    {
      throw localSmartFrogException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public boolean sfValid()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfValid_107, null, 167052152300044534L);
        return ((Boolean)localObject1).booleanValue();
      }
      Object localObject1 = this.ref.newCall(this, operations, 107, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      boolean bool;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        bool = localObjectInput.readBoolean();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }

  public Iterator sfValues()
    throws RemoteException
  {
    try
    {
      if (useNewInvoke)
      {
        localObject1 = this.ref.invoke(this, $method_sfValues_108, null, -2602691383856360599L);
        return (Iterator)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 108, 95256091449878667L);
      this.ref.invoke((RemoteCall)localObject1);
      Iterator localIterator;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localIterator = (Iterator)localObjectInput.readObject();
      }
      catch (IOException localIOException)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localIterator;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (Exception localException)
    {
    }
    throw new UnexpectedException("undeclared checked exception", localException);
  }
}

/* Location:           /home/mnovak/tmp/terminate-hook/
 * Qualified Name:     org.jboss.smartfrog.utils.TerminateHookImpl_Stub
 * JD-Core Version:    0.6.0
 */