package org.jboss.smartfrog.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.InetAddress;
import java.net.URL;
import java.rmi.MarshalException;
import java.rmi.Remote;
import java.rmi.UnmarshalException;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.Skeleton;
import java.rmi.server.SkeletonMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.smartfrog.sfcore.common.Context;
import org.smartfrog.sfcore.componentdescription.ComponentDescription;
import org.smartfrog.sfcore.compound.Compound;
import org.smartfrog.sfcore.compound.CompoundImpl;
import org.smartfrog.sfcore.prim.Dump;
import org.smartfrog.sfcore.prim.Liveness;
import org.smartfrog.sfcore.prim.Prim;
import org.smartfrog.sfcore.prim.PrimImpl;
import org.smartfrog.sfcore.prim.TerminationRecord;
import org.smartfrog.sfcore.reference.Reference;
import org.smartfrog.sfcore.reference.RemoteReferenceResolverHelperImpl;

public final class TerminateHookImpl_Skel
  implements Skeleton
{
  private static final Operation[] operations = { new Operation("void sfAbandonUpdate()"), new Operation("java.lang.Object sfAddAttribute(java.lang.Object, java.lang.Object)"), new Operation("void sfAddChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("void sfAddTag(java.lang.Object, java.lang.String)"), new Operation("void sfAddTag(java.lang.String)"), new Operation("void sfAddTags(java.lang.Object, java.util.Set)"), new Operation("void sfAddTags(java.util.Set)"), new Operation("java.lang.Object sfAttributeKeyFor(java.lang.Object)"), new Operation("java.util.Iterator sfAttributes()"), new Operation("java.util.Enumeration sfChildren()"), new Operation("org.smartfrog.sfcore.reference.Reference sfCompleteName()"), new Operation("boolean sfContainsAttribute(java.lang.Object)"), new Operation("boolean sfContainsChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("boolean sfContainsTag(java.lang.Object, java.lang.String)"), new Operation("boolean sfContainsTag(java.lang.String)"), new Operation("boolean sfContainsValue(java.lang.Object)"), new Operation("org.smartfrog.sfcore.common.Context sfContext()"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewApp(java.lang.String, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewChild(java.lang.Object, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("org.smartfrog.sfcore.prim.Prim sfCreateNewChild(java.lang.Object, org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("void sfDeploy()"), new Operation("org.smartfrog.sfcore.prim.Prim sfDeployComponentDescription(java.lang.Object, org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.componentdescription.ComponentDescription, org.smartfrog.sfcore.common.Context)"), new Operation("void sfDeployWith(org.smartfrog.sfcore.prim.Prim, org.smartfrog.sfcore.common.Context)"), new Operation("java.net.InetAddress sfDeployedHost()"), new Operation("java.lang.String sfDeployedProcessName()"), new Operation("void sfDetach()"), new Operation("void sfDetachAndTerminate(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfDiagnosticsReport()"), new Operation("void sfDumpState(org.smartfrog.sfcore.prim.Dump)"), new Operation("java.util.Set sfGetTags()"), new Operation("java.util.Set sfGetTags(java.lang.Object)"), new Operation("boolean sfIsDeployed()"), new Operation("boolean sfIsStarted()"), new Operation("boolean sfIsTerminated()"), new Operation("boolean sfIsTerminating()"), new Operation("org.smartfrog.sfcore.prim.Prim sfParent()"), new Operation("void sfParentageChanged()"), new Operation("void sfPing(java.lang.Object)"), new Operation("void sfPrepareUpdate()"), new Operation("java.lang.Object sfRemoveAttribute(java.lang.Object)"), new Operation("boolean sfRemoveChild(org.smartfrog.sfcore.prim.Liveness)"), new Operation("void sfRemoveTag(java.lang.Object, java.lang.String)"), new Operation("void sfRemoveTag(java.lang.String)"), new Operation("void sfRemoveTags(java.lang.Object, java.util.Set)"), new Operation("void sfRemoveTags(java.util.Set)"), new Operation("java.lang.Object sfReplaceAttribute(java.lang.Object, java.lang.Object)"), new Operation("java.lang.Object sfResolve(java.lang.String)"), new Operation("double sfResolve(java.lang.String, double, java.lang.Double, java.lang.Double, boolean)"), new Operation("double sfResolve(java.lang.String, double, boolean)"), new Operation("float sfResolve(java.lang.String, float, java.lang.Float, java.lang.Float, boolean)"), new Operation("float sfResolve(java.lang.String, float, boolean)"), new Operation("int sfResolve(java.lang.String, int, java.lang.Integer, java.lang.Integer, boolean)"), new Operation("int sfResolve(java.lang.String, int, boolean)"), new Operation("long sfResolve(java.lang.String, long, java.lang.Long, java.lang.Long, boolean)"), new Operation("long sfResolve(java.lang.String, long, boolean)"), new Operation("java.io.File sfResolve(java.lang.String, java.io.File, boolean)"), new Operation("java.lang.Object sfResolve(java.lang.String, java.lang.Object, boolean)"), new Operation("java.lang.String sfResolve(java.lang.String, java.lang.String, boolean)"), new Operation("java.net.InetAddress sfResolve(java.lang.String, java.net.InetAddress, boolean)"), new Operation("java.net.URL sfResolve(java.lang.String, java.net.URL, boolean)"), new Operation("java.util.Vector sfResolve(java.lang.String, java.util.Vector, boolean)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfResolve(java.lang.String, org.smartfrog.sfcore.componentdescription.ComponentDescription, boolean)"), new Operation("org.smartfrog.sfcore.compound.Compound sfResolve(java.lang.String, org.smartfrog.sfcore.compound.Compound, boolean)"), new Operation("org.smartfrog.sfcore.prim.Prim sfResolve(java.lang.String, org.smartfrog.sfcore.prim.Prim, boolean)"), new Operation("org.smartfrog.sfcore.reference.Reference sfResolve(java.lang.String, org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("java.lang.Object sfResolve(java.lang.String, boolean)"), new Operation("boolean sfResolve(java.lang.String, boolean, boolean)"), new Operation("java.lang.String sfResolve(java.lang.String, java.lang.String[], boolean)[]"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference)"), new Operation("double sfResolve(org.smartfrog.sfcore.reference.Reference, double, java.lang.Double, java.lang.Double, boolean)"), new Operation("double sfResolve(org.smartfrog.sfcore.reference.Reference, double, boolean)"), new Operation("float sfResolve(org.smartfrog.sfcore.reference.Reference, float, java.lang.Float, java.lang.Float, boolean)"), new Operation("float sfResolve(org.smartfrog.sfcore.reference.Reference, float, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, int)"), new Operation("int sfResolve(org.smartfrog.sfcore.reference.Reference, int, java.lang.Integer, java.lang.Integer, boolean)"), new Operation("int sfResolve(org.smartfrog.sfcore.reference.Reference, int, boolean)"), new Operation("long sfResolve(org.smartfrog.sfcore.reference.Reference, long, java.lang.Long, java.lang.Long, boolean)"), new Operation("long sfResolve(org.smartfrog.sfcore.reference.Reference, long, boolean)"), new Operation("java.io.File sfResolve(org.smartfrog.sfcore.reference.Reference, java.io.File, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.Object, boolean)"), new Operation("java.lang.String sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.String, boolean)"), new Operation("java.net.InetAddress sfResolve(org.smartfrog.sfcore.reference.Reference, java.net.InetAddress, boolean)"), new Operation("java.net.URL sfResolve(org.smartfrog.sfcore.reference.Reference, java.net.URL, boolean)"), new Operation("java.util.Vector sfResolve(org.smartfrog.sfcore.reference.Reference, java.util.Vector, boolean)"), new Operation("org.smartfrog.sfcore.componentdescription.ComponentDescription sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.componentdescription.ComponentDescription, boolean)"), new Operation("org.smartfrog.sfcore.compound.Compound sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.compound.Compound, boolean)"), new Operation("org.smartfrog.sfcore.prim.Prim sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.prim.Prim, boolean)"), new Operation("org.smartfrog.sfcore.reference.Reference sfResolve(org.smartfrog.sfcore.reference.Reference, org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("java.lang.Object sfResolve(org.smartfrog.sfcore.reference.Reference, boolean)"), new Operation("boolean sfResolve(org.smartfrog.sfcore.reference.Reference, boolean, boolean)"), new Operation("java.lang.String sfResolve(org.smartfrog.sfcore.reference.Reference, java.lang.String[], boolean)[]"), new Operation("java.lang.Object sfResolveHere(java.lang.Object)"), new Operation("java.lang.Object sfResolveHere(java.lang.Object, boolean)"), new Operation("java.lang.Object sfResolveHereNonlocal(java.lang.Object, boolean)"), new Operation("java.lang.Object sfResolveParent()"), new Operation("java.lang.Object sfResolveWithParser(java.lang.String)"), new Operation("void sfSetTags(java.lang.Object, java.util.Set)"), new Operation("void sfSetTags(java.util.Set)"), new Operation("void sfStart()"), new Operation("void sfTerminate(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("void sfTerminateQuietlyWith(org.smartfrog.sfcore.prim.TerminationRecord)"), new Operation("void sfTerminatedWith(org.smartfrog.sfcore.prim.TerminationRecord, org.smartfrog.sfcore.prim.Prim)"), new Operation("void sfUpdate()"), new Operation("void sfUpdateComponent(org.smartfrog.sfcore.componentdescription.ComponentDescription)"), new Operation("void sfUpdateDeploy()"), new Operation("void sfUpdateStart()"), new Operation("boolean sfUpdateWith(org.smartfrog.sfcore.common.Context)"), new Operation("boolean sfValid()"), new Operation("java.util.Iterator sfValues()") };
  private static final long interfaceHash = 95256091449878667L;

  public void dispatch(Remote paramRemote, RemoteCall paramRemoteCall, int paramInt, long paramLong)
    throws Exception
  {
    if (paramInt < 0)
    {
      if (paramLong == 8795384095142827219L)
        paramInt = 0;
      else if (paramLong == -752402149624012578L)
        paramInt = 1;
      else if (paramLong == -4988964723608828241L)
        paramInt = 2;
      else if (paramLong == 5222344892867082436L)
        paramInt = 3;
      else if (paramLong == -5292244336360487324L)
        paramInt = 4;
      else if (paramLong == -2482714145755934402L)
        paramInt = 5;
      else if (paramLong == -4250655186362973831L)
        paramInt = 6;
      else if (paramLong == 917196947060357926L)
        paramInt = 7;
      else if (paramLong == -1120450218948359869L)
        paramInt = 8;
      else if (paramLong == 2596040897270252721L)
        paramInt = 9;
      else if (paramLong == 3408786407923213136L)
        paramInt = 10;
      else if (paramLong == 1321146646653078930L)
        paramInt = 11;
      else if (paramLong == 340935267262165043L)
        paramInt = 12;
      else if (paramLong == 8877310763612801403L)
        paramInt = 13;
      else if (paramLong == -972907250431561467L)
        paramInt = 14;
      else if (paramLong == 4680488223455576288L)
        paramInt = 15;
      else if (paramLong == -7894887194218774960L)
        paramInt = 16;
      else if (paramLong == -5141359607666207938L)
        paramInt = 17;
      else if (paramLong == -2248185910595993620L)
        paramInt = 18;
      else if (paramLong == 2826307050079361112L)
        paramInt = 19;
      else if (paramLong == -1241400586518897420L)
        paramInt = 20;
      else if (paramLong == 7880370046911499052L)
        paramInt = 21;
      else if (paramLong == 9013997983066141239L)
        paramInt = 22;
      else if (paramLong == -7925557175482833480L)
        paramInt = 23;
      else if (paramLong == -4296462462832072885L)
        paramInt = 24;
      else if (paramLong == 7758033736977330935L)
        paramInt = 25;
      else if (paramLong == -6011442031957692318L)
        paramInt = 26;
      else if (paramLong == -4566415224652611266L)
        paramInt = 27;
      else if (paramLong == 3857681078674752434L)
        paramInt = 28;
      else if (paramLong == -4728466950669802219L)
        paramInt = 29;
      else if (paramLong == -7181563682722928331L)
        paramInt = 30;
      else if (paramLong == 3065601471260862548L)
        paramInt = 31;
      else if (paramLong == 8410625712945957863L)
        paramInt = 32;
      else if (paramLong == -7366981244650170840L)
        paramInt = 33;
      else if (paramLong == -3399352455048426083L)
        paramInt = 34;
      else if (paramLong == 7250859113734339498L)
        paramInt = 35;
      else if (paramLong == -2354166004782981419L)
        paramInt = 36;
      else if (paramLong == -85108778267501922L)
        paramInt = 37;
      else if (paramLong == 4077533068082565925L)
        paramInt = 38;
      else if (paramLong == -1342154479564100882L)
        paramInt = 39;
      else if (paramLong == 5342293696341823625L)
        paramInt = 40;
      else if (paramLong == 1928981356880354640L)
        paramInt = 41;
      else if (paramLong == -3488580036607004553L)
        paramInt = 42;
      else if (paramLong == 8272091395929014291L)
        paramInt = 43;
      else if (paramLong == -2694742808033540268L)
        paramInt = 44;
      else if (paramLong == -4876583954089213984L)
        paramInt = 45;
      else if (paramLong == -2040128981771466702L)
        paramInt = 46;
      else if (paramLong == -2534242255933564619L)
        paramInt = 47;
      else if (paramLong == -2959792927313069734L)
        paramInt = 48;
      else if (paramLong == 1493379802569519239L)
        paramInt = 49;
      else if (paramLong == 4019130728270226649L)
        paramInt = 50;
      else if (paramLong == -5799916151847019931L)
        paramInt = 51;
      else if (paramLong == 7349824546392467963L)
        paramInt = 52;
      else if (paramLong == 3730994026809185944L)
        paramInt = 53;
      else if (paramLong == 8759690098061519321L)
        paramInt = 54;
      else if (paramLong == 2896087789186144059L)
        paramInt = 55;
      else if (paramLong == -5779905306292514673L)
        paramInt = 56;
      else if (paramLong == -4287252325521442856L)
        paramInt = 57;
      else if (paramLong == -6299349214437391645L)
        paramInt = 58;
      else if (paramLong == 2641105198246316628L)
        paramInt = 59;
      else if (paramLong == -7457079736029033266L)
        paramInt = 60;
      else if (paramLong == 278147432822912651L)
        paramInt = 61;
      else if (paramLong == 1850765839868180218L)
        paramInt = 62;
      else if (paramLong == 7620381415800346879L)
        paramInt = 63;
      else if (paramLong == -768190330923711433L)
        paramInt = 64;
      else if (paramLong == -5526512742624578005L)
        paramInt = 65;
      else if (paramLong == 3074056645332798871L)
        paramInt = 66;
      else if (paramLong == -261531959238447026L)
        paramInt = 67;
      else if (paramLong == 2723606398882502132L)
        paramInt = 68;
      else if (paramLong == 1163355191403457648L)
        paramInt = 69;
      else if (paramLong == 8228713188388847761L)
        paramInt = 70;
      else if (paramLong == -2101728420131928136L)
        paramInt = 71;
      else if (paramLong == 6354277681639172604L)
        paramInt = 72;
      else if (paramLong == 5873372285246974544L)
        paramInt = 73;
      else if (paramLong == -7651263432762410531L)
        paramInt = 74;
      else if (paramLong == -297990108419193880L)
        paramInt = 75;
      else if (paramLong == -7496236984885271095L)
        paramInt = 76;
      else if (paramLong == -5899506294683753348L)
        paramInt = 77;
      else if (paramLong == -2079121628557084148L)
        paramInt = 78;
      else if (paramLong == -3430394161774247870L)
        paramInt = 79;
      else if (paramLong == 2922238431955583955L)
        paramInt = 80;
      else if (paramLong == 4579525934675499763L)
        paramInt = 81;
      else if (paramLong == 109120547210689151L)
        paramInt = 82;
      else if (paramLong == -2984838881853226953L)
        paramInt = 83;
      else if (paramLong == 1041372419954209560L)
        paramInt = 84;
      else if (paramLong == -1662604997403230368L)
        paramInt = 85;
      else if (paramLong == -1672544750669587866L)
        paramInt = 86;
      else if (paramLong == -648918243307555357L)
        paramInt = 87;
      else if (paramLong == -7284746406181901887L)
        paramInt = 88;
      else if (paramLong == 2279481227005775614L)
        paramInt = 89;
      else if (paramLong == -7253456114976696912L)
        paramInt = 90;
      else if (paramLong == 6973307674343303035L)
        paramInt = 91;
      else if (paramLong == 1780962583192600160L)
        paramInt = 92;
      else if (paramLong == 2760027684983779767L)
        paramInt = 93;
      else if (paramLong == 2630687939934197351L)
        paramInt = 94;
      else if (paramLong == -1587196096168695961L)
        paramInt = 95;
      else if (paramLong == 9065223492846062597L)
        paramInt = 96;
      else if (paramLong == 2341858194978505393L)
        paramInt = 97;
      else if (paramLong == 5760549645760591948L)
        paramInt = 98;
      else if (paramLong == -1353479667122505023L)
        paramInt = 99;
      else if (paramLong == 5849629192947399252L)
        paramInt = 100;
      else if (paramLong == 2893824888564780976L)
        paramInt = 101;
      else if (paramLong == -4763275676445796821L)
        paramInt = 102;
      else if (paramLong == 7167319618838809995L)
        paramInt = 103;
      else if (paramLong == -471903359761229907L)
        paramInt = 104;
      else if (paramLong == 3210047280676871217L)
        paramInt = 105;
      else if (paramLong == -4839307845624642844L)
        paramInt = 106;
      else if (paramLong == 167052152300044534L)
        paramInt = 107;
      else if (paramLong == -2602691383856360599L)
        paramInt = 108;
      else
        throw new UnmarshalException("invalid method hash");
    }
    else if (paramLong != 95256091449878667L)
      throw new SkeletonMismatchException("interface hash mismatch");
    TerminateHookImpl localTerminateHookImpl = (TerminateHookImpl)paramRemote;
    Object localObject1;
    Object localObject11;
    Object localObject16;
    Object localObject56;
    Object localObject97;
    Object localObject2;
    Object localObject145;
    Object localObject3;
    Object localObject20;
    boolean bool1;
    Object localObject5;
    double d1;
    float f1;
    int i;
    boolean bool14;
    long l1;
    Object localObject30;
    boolean bool8;
    boolean bool15;
    Object localObject118;
    double d2;
    float f2;
    int j;
    Object localObject75;
    boolean bool17;
    long l2;
    Object localObject33;
    boolean bool9;
    boolean bool18;
    Object localObject136;
    boolean bool10;
    Object localObject37;
    TerminationRecord localTerminationRecord;
    switch (paramInt)
    {
    case 0:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfAbandonUpdate();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling return", localIOException1);
      }
    case 1:
      Object localObject6;
      try
      {
        ObjectInput localObjectInput24 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput24.readObject();
        localObject6 = localObjectInput24.readObject();
      }
      catch (IOException localIOException91)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException91);
      }
      catch (ClassNotFoundException localClassNotFoundException26)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException26);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject44 = localTerminateHookImpl.sfAddAttribute(localObject1, localObject6);
      try
      {
        ObjectOutput localObjectOutput27 = paramRemoteCall.getResultStream(true);
        localObjectOutput27.writeObject(localObject44);
      }
      catch (IOException localIOException58)
      {
        throw new MarshalException("error marshalling return", localIOException58);
      }
    case 2:
      try
      {
        ObjectInput localObjectInput1 = paramRemoteCall.getInputStream();
        localObject1 = (Liveness)localObjectInput1.readObject();
      }
      catch (IOException localIOException59)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException59);
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException1);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfAddChild((Liveness)localObject1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException10)
      {
        throw new MarshalException("error marshalling return", localIOException10);
      }
    case 3:
      String str1;
      try
      {
        ObjectInput localObjectInput25 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput25.readObject();
        str1 = (String)localObjectInput25.readObject();
      }
      catch (IOException localIOException92)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException92);
      }
      catch (ClassNotFoundException localClassNotFoundException27)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException27);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfAddTag(localObject1, str1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException38)
      {
        throw new MarshalException("error marshalling return", localIOException38);
      }
    case 4:
      try
      {
        ObjectInput localObjectInput2 = paramRemoteCall.getInputStream();
        localObject1 = (String)localObjectInput2.readObject();
      }
      catch (IOException localIOException60)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException60);
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException2);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfAddTag((String)localObject1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException11)
      {
        throw new MarshalException("error marshalling return", localIOException11);
      }
    case 5:
      Set localSet1;
      try
      {
        ObjectInput localObjectInput26 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput26.readObject();
        localSet1 = (Set)localObjectInput26.readObject();
      }
      catch (IOException localIOException93)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException93);
      }
      catch (ClassNotFoundException localClassNotFoundException28)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException28);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfAddTags(localObject1, localSet1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException39)
      {
        throw new MarshalException("error marshalling return", localIOException39);
      }
    case 6:
      try
      {
        ObjectInput localObjectInput3 = paramRemoteCall.getInputStream();
        localObject1 = (Set)localObjectInput3.readObject();
      }
      catch (IOException localIOException61)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException61);
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException3);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfAddTags((Set)localObject1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException12)
      {
        throw new MarshalException("error marshalling return", localIOException12);
      }
    case 7:
      try
      {
        ObjectInput localObjectInput4 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput4.readObject();
      }
      catch (IOException localIOException62)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException62);
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException4);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject11 = localTerminateHookImpl.sfAttributeKeyFor(localObject1);
      try
      {
        ObjectOutput localObjectOutput14 = paramRemoteCall.getResultStream(true);
        localObjectOutput14.writeObject(localObject11);
      }
      catch (IOException localIOException40)
      {
        throw new MarshalException("error marshalling return", localIOException40);
      }
    case 8:
      paramRemoteCall.releaseInputStream();
      localObject1 = localTerminateHookImpl.sfAttributes();
      try
      {
        localObject11 = paramRemoteCall.getResultStream(true);
        ((ObjectOutput)localObject11).writeObject(localObject1);
      }
      catch (IOException localIOException13)
      {
        throw new MarshalException("error marshalling return", localIOException13);
      }
    case 9:
      paramRemoteCall.releaseInputStream();
      localObject1 = localTerminateHookImpl.sfChildren();
      try
      {
        ObjectOutput localObjectOutput1 = paramRemoteCall.getResultStream(true);
        localObjectOutput1.writeObject(localObject1);
      }
      catch (IOException localIOException14)
      {
        throw new MarshalException("error marshalling return", localIOException14);
      }
    case 10:
      paramRemoteCall.releaseInputStream();
      localObject1 = localTerminateHookImpl.sfCompleteName();
      try
      {
        ObjectOutput localObjectOutput2 = paramRemoteCall.getResultStream(true);
        localObjectOutput2.writeObject(localObject1);
      }
      catch (IOException localIOException15)
      {
        throw new MarshalException("error marshalling return", localIOException15);
      }
    case 11:
      try
      {
        ObjectInput localObjectInput5 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput5.readObject();
      }
      catch (IOException localIOException63)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException63);
      }
      catch (ClassNotFoundException localClassNotFoundException5)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException5);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool3 = localTerminateHookImpl.sfContainsAttribute(localObject1);
      try
      {
        ObjectOutput localObjectOutput15 = paramRemoteCall.getResultStream(true);
        localObjectOutput15.writeBoolean(bool3);
      }
      catch (IOException localIOException41)
      {
        throw new MarshalException("error marshalling return", localIOException41);
      }
    case 12:
      try
      {
        ObjectInput localObjectInput6 = paramRemoteCall.getInputStream();
        localObject1 = (Liveness)localObjectInput6.readObject();
      }
      catch (IOException localIOException64)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException64);
      }
      catch (ClassNotFoundException localClassNotFoundException6)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException6);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool4 = localTerminateHookImpl.sfContainsChild((Liveness)localObject1);
      try
      {
        ObjectOutput localObjectOutput16 = paramRemoteCall.getResultStream(true);
        localObjectOutput16.writeBoolean(bool4);
      }
      catch (IOException localIOException42)
      {
        throw new MarshalException("error marshalling return", localIOException42);
      }
    case 13:
      String str2;
      try
      {
        ObjectInput localObjectInput27 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput27.readObject();
        str2 = (String)localObjectInput27.readObject();
      }
      catch (IOException localIOException94)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException94);
      }
      catch (ClassNotFoundException localClassNotFoundException29)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException29);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool12 = localTerminateHookImpl.sfContainsTag(localObject1, str2);
      try
      {
        ObjectOutput localObjectOutput28 = paramRemoteCall.getResultStream(true);
        localObjectOutput28.writeBoolean(bool12);
      }
      catch (IOException localIOException65)
      {
        throw new MarshalException("error marshalling return", localIOException65);
      }
    case 14:
      try
      {
        ObjectInput localObjectInput7 = paramRemoteCall.getInputStream();
        localObject1 = (String)localObjectInput7.readObject();
      }
      catch (IOException localIOException66)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException66);
      }
      catch (ClassNotFoundException localClassNotFoundException7)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException7);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool5 = localTerminateHookImpl.sfContainsTag((String)localObject1);
      try
      {
        ObjectOutput localObjectOutput17 = paramRemoteCall.getResultStream(true);
        localObjectOutput17.writeBoolean(bool5);
      }
      catch (IOException localIOException43)
      {
        throw new MarshalException("error marshalling return", localIOException43);
      }
    case 15:
      try
      {
        ObjectInput localObjectInput8 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput8.readObject();
      }
      catch (IOException localIOException67)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException67);
      }
      catch (ClassNotFoundException localClassNotFoundException8)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException8);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool6 = localTerminateHookImpl.sfContainsValue(localObject1);
      try
      {
        ObjectOutput localObjectOutput18 = paramRemoteCall.getResultStream(true);
        localObjectOutput18.writeBoolean(bool6);
      }
      catch (IOException localIOException44)
      {
        throw new MarshalException("error marshalling return", localIOException44);
      }
    case 16:
      paramRemoteCall.releaseInputStream();
      localObject1 = localTerminateHookImpl.sfContext();
      try
      {
        ObjectOutput localObjectOutput3 = paramRemoteCall.getResultStream(true);
        localObjectOutput3.writeObject(localObject1);
      }
      catch (IOException localIOException16)
      {
        throw new MarshalException("error marshalling return", localIOException16);
      }
    case 17:
      try
      {
        ObjectInput localObjectInput38 = paramRemoteCall.getInputStream();
        localObject1 = (String)localObjectInput38.readObject();
        localObject16 = (ComponentDescription)localObjectInput38.readObject();
        localObject56 = (Context)localObjectInput38.readObject();
      }
      catch (IOException localIOException136)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException136);
      }
      catch (ClassNotFoundException localClassNotFoundException41)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException41);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Prim localPrim3 = localTerminateHookImpl.sfCreateNewApp((String)localObject1, (ComponentDescription)localObject16, (Context)localObject56);
      try
      {
        ObjectOutput localObjectOutput35 = paramRemoteCall.getResultStream(true);
        localObjectOutput35.writeObject(localPrim3);
      }
      catch (IOException localIOException95)
      {
        throw new MarshalException("error marshalling return", localIOException95);
      }
    case 18:
      try
      {
        ObjectInput localObjectInput39 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput39.readObject();
        localObject16 = (ComponentDescription)localObjectInput39.readObject();
        localObject56 = (Context)localObjectInput39.readObject();
      }
      catch (IOException localIOException137)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException137);
      }
      catch (ClassNotFoundException localClassNotFoundException42)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException42);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject97 = localTerminateHookImpl.sfCreateNewChild(localObject1, (ComponentDescription)localObject16, (Context)localObject56);
      try
      {
        ObjectOutput localObjectOutput36 = paramRemoteCall.getResultStream(true);
        localObjectOutput36.writeObject(localObject97);
      }
      catch (IOException localIOException96)
      {
        throw new MarshalException("error marshalling return", localIOException96);
      }
    case 19:
      try
      {
        ObjectInput localObjectInput68 = paramRemoteCall.getInputStream();
        localObject1 = localObjectInput68.readObject();
        localObject16 = (Prim)localObjectInput68.readObject();
        localObject56 = (ComponentDescription)localObjectInput68.readObject();
        localObject97 = (Context)localObjectInput68.readObject();
      }
      catch (IOException localIOException168)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException168);
      }
      catch (ClassNotFoundException localClassNotFoundException71)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException71);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Prim localPrim6 = localTerminateHookImpl.sfCreateNewChild(localObject1, (Prim)localObject16, (ComponentDescription)localObject56, (Context)localObject97);
      try
      {
        ObjectOutput localObjectOutput65 = paramRemoteCall.getResultStream(true);
        localObjectOutput65.writeObject(localPrim6);
      }
      catch (IOException localIOException138)
      {
        throw new MarshalException("error marshalling return", localIOException138);
      }
    case 20:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfDeploy();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException2)
      {
        throw new MarshalException("error marshalling return", localIOException2);
      }
    case 21:
      try
      {
        ObjectInput localObjectInput69 = paramRemoteCall.getInputStream();
        localObject2 = localObjectInput69.readObject();
        localObject16 = (Prim)localObjectInput69.readObject();
        localObject56 = (ComponentDescription)localObjectInput69.readObject();
        localObject97 = (Context)localObjectInput69.readObject();
      }
      catch (IOException localIOException169)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException169);
      }
      catch (ClassNotFoundException localClassNotFoundException72)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException72);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject145 = localTerminateHookImpl.sfDeployComponentDescription(localObject2, (Prim)localObject16, (ComponentDescription)localObject56, (Context)localObject97);
      try
      {
        ObjectOutput localObjectOutput66 = paramRemoteCall.getResultStream(true);
        localObjectOutput66.writeObject(localObject145);
      }
      catch (IOException localIOException139)
      {
        throw new MarshalException("error marshalling return", localIOException139);
      }
    case 22:
      try
      {
        localObject145 = paramRemoteCall.getInputStream();
        localObject2 = (Prim)((ObjectInput)localObject145).readObject();
        localObject16 = (Context)((ObjectInput)localObject145).readObject();
      }
      catch (IOException localIOException97)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException97);
      }
      catch (ClassNotFoundException localClassNotFoundException30)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException30);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfDeployWith((Prim)localObject2, (Context)localObject16);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException45)
      {
        throw new MarshalException("error marshalling return", localIOException45);
      }
    case 23:
      paramRemoteCall.releaseInputStream();
      localObject2 = localTerminateHookImpl.sfDeployedHost();
      try
      {
        localObject16 = paramRemoteCall.getResultStream(true);
        ((ObjectOutput)localObject16).writeObject(localObject2);
      }
      catch (IOException localIOException17)
      {
        throw new MarshalException("error marshalling return", localIOException17);
      }
    case 24:
      paramRemoteCall.releaseInputStream();
      localObject2 = localTerminateHookImpl.sfDeployedProcessName();
      try
      {
        ObjectOutput localObjectOutput4 = paramRemoteCall.getResultStream(true);
        localObjectOutput4.writeObject(localObject2);
      }
      catch (IOException localIOException18)
      {
        throw new MarshalException("error marshalling return", localIOException18);
      }
    case 25:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfDetach();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException3)
      {
        throw new MarshalException("error marshalling return", localIOException3);
      }
    case 26:
      try
      {
        ObjectInput localObjectInput9 = paramRemoteCall.getInputStream();
        localObject3 = (TerminationRecord)localObjectInput9.readObject();
      }
      catch (IOException localIOException68)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException68);
      }
      catch (ClassNotFoundException localClassNotFoundException9)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException9);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfDetachAndTerminate((TerminationRecord)localObject3);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException19)
      {
        throw new MarshalException("error marshalling return", localIOException19);
      }
    case 27:
      paramRemoteCall.releaseInputStream();
      localObject3 = localTerminateHookImpl.sfDiagnosticsReport();
      try
      {
        ObjectOutput localObjectOutput5 = paramRemoteCall.getResultStream(true);
        localObjectOutput5.writeObject(localObject3);
      }
      catch (IOException localIOException20)
      {
        throw new MarshalException("error marshalling return", localIOException20);
      }
    case 28:
      try
      {
        ObjectInput localObjectInput10 = paramRemoteCall.getInputStream();
        localObject3 = (Dump)localObjectInput10.readObject();
      }
      catch (IOException localIOException69)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException69);
      }
      catch (ClassNotFoundException localClassNotFoundException10)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException10);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfDumpState((Dump)localObject3);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException21)
      {
        throw new MarshalException("error marshalling return", localIOException21);
      }
    case 29:
      paramRemoteCall.releaseInputStream();
      localObject3 = localTerminateHookImpl.sfGetTags();
      try
      {
        ObjectOutput localObjectOutput6 = paramRemoteCall.getResultStream(true);
        localObjectOutput6.writeObject(localObject3);
      }
      catch (IOException localIOException22)
      {
        throw new MarshalException("error marshalling return", localIOException22);
      }
    case 30:
      try
      {
        ObjectInput localObjectInput11 = paramRemoteCall.getInputStream();
        localObject3 = localObjectInput11.readObject();
      }
      catch (IOException localIOException70)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException70);
      }
      catch (ClassNotFoundException localClassNotFoundException11)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException11);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject20 = localTerminateHookImpl.sfGetTags(localObject3);
      try
      {
        ObjectOutput localObjectOutput19 = paramRemoteCall.getResultStream(true);
        localObjectOutput19.writeObject(localObject20);
      }
      catch (IOException localIOException46)
      {
        throw new MarshalException("error marshalling return", localIOException46);
      }
    case 31:
      paramRemoteCall.releaseInputStream();
      bool1 = localTerminateHookImpl.sfIsDeployed();
      try
      {
        localObject20 = paramRemoteCall.getResultStream(true);
        ((DataOutput)localObject20).writeBoolean(bool1);
      }
      catch (IOException localIOException23)
      {
        throw new MarshalException("error marshalling return", localIOException23);
      }
    case 32:
      paramRemoteCall.releaseInputStream();
      bool1 = localTerminateHookImpl.sfIsStarted();
      try
      {
        ObjectOutput localObjectOutput7 = paramRemoteCall.getResultStream(true);
        localObjectOutput7.writeBoolean(bool1);
      }
      catch (IOException localIOException24)
      {
        throw new MarshalException("error marshalling return", localIOException24);
      }
    case 33:
      paramRemoteCall.releaseInputStream();
      bool1 = localTerminateHookImpl.sfIsTerminated();
      try
      {
        ObjectOutput localObjectOutput8 = paramRemoteCall.getResultStream(true);
        localObjectOutput8.writeBoolean(bool1);
      }
      catch (IOException localIOException25)
      {
        throw new MarshalException("error marshalling return", localIOException25);
      }
    case 34:
      paramRemoteCall.releaseInputStream();
      bool1 = localTerminateHookImpl.sfIsTerminating();
      try
      {
        ObjectOutput localObjectOutput9 = paramRemoteCall.getResultStream(true);
        localObjectOutput9.writeBoolean(bool1);
      }
      catch (IOException localIOException26)
      {
        throw new MarshalException("error marshalling return", localIOException26);
      }
    case 35:
      paramRemoteCall.releaseInputStream();
      Prim localPrim1 = localTerminateHookImpl.sfParent();
      try
      {
        ObjectOutput localObjectOutput10 = paramRemoteCall.getResultStream(true);
        localObjectOutput10.writeObject(localPrim1);
      }
      catch (IOException localIOException27)
      {
        throw new MarshalException("error marshalling return", localIOException27);
      }
    case 36:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfParentageChanged();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException4)
      {
        throw new MarshalException("error marshalling return", localIOException4);
      }
    case 37:
      Object localObject4;
      try
      {
        ObjectInput localObjectInput12 = paramRemoteCall.getInputStream();
        localObject4 = localObjectInput12.readObject();
      }
      catch (IOException localIOException71)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException71);
      }
      catch (ClassNotFoundException localClassNotFoundException12)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException12);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfPing(localObject4);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException28)
      {
        throw new MarshalException("error marshalling return", localIOException28);
      }
    case 38:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfPrepareUpdate();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException5)
      {
        throw new MarshalException("error marshalling return", localIOException5);
      }
    case 39:
      try
      {
        ObjectInput localObjectInput13 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput13.readObject();
      }
      catch (IOException localIOException72)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException72);
      }
      catch (ClassNotFoundException localClassNotFoundException13)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException13);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject23 = localTerminateHookImpl.sfRemoveAttribute(localObject5);
      try
      {
        ObjectOutput localObjectOutput20 = paramRemoteCall.getResultStream(true);
        localObjectOutput20.writeObject(localObject23);
      }
      catch (IOException localIOException47)
      {
        throw new MarshalException("error marshalling return", localIOException47);
      }
    case 40:
      try
      {
        ObjectInput localObjectInput14 = paramRemoteCall.getInputStream();
        localObject5 = (Liveness)localObjectInput14.readObject();
      }
      catch (IOException localIOException73)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException73);
      }
      catch (ClassNotFoundException localClassNotFoundException14)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException14);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool7 = localTerminateHookImpl.sfRemoveChild((Liveness)localObject5);
      try
      {
        ObjectOutput localObjectOutput21 = paramRemoteCall.getResultStream(true);
        localObjectOutput21.writeBoolean(bool7);
      }
      catch (IOException localIOException48)
      {
        throw new MarshalException("error marshalling return", localIOException48);
      }
    case 41:
      String str3;
      try
      {
        ObjectInput localObjectInput28 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput28.readObject();
        str3 = (String)localObjectInput28.readObject();
      }
      catch (IOException localIOException98)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException98);
      }
      catch (ClassNotFoundException localClassNotFoundException31)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException31);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfRemoveTag(localObject5, str3);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException49)
      {
        throw new MarshalException("error marshalling return", localIOException49);
      }
    case 42:
      try
      {
        ObjectInput localObjectInput15 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput15.readObject();
      }
      catch (IOException localIOException74)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException74);
      }
      catch (ClassNotFoundException localClassNotFoundException15)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException15);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfRemoveTag((String)localObject5);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException29)
      {
        throw new MarshalException("error marshalling return", localIOException29);
      }
    case 43:
      Set localSet2;
      try
      {
        ObjectInput localObjectInput29 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput29.readObject();
        localSet2 = (Set)localObjectInput29.readObject();
      }
      catch (IOException localIOException99)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException99);
      }
      catch (ClassNotFoundException localClassNotFoundException32)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException32);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfRemoveTags(localObject5, localSet2);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException50)
      {
        throw new MarshalException("error marshalling return", localIOException50);
      }
    case 44:
      try
      {
        ObjectInput localObjectInput16 = paramRemoteCall.getInputStream();
        localObject5 = (Set)localObjectInput16.readObject();
      }
      catch (IOException localIOException75)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException75);
      }
      catch (ClassNotFoundException localClassNotFoundException16)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException16);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfRemoveTags((Set)localObject5);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException30)
      {
        throw new MarshalException("error marshalling return", localIOException30);
      }
    case 45:
      Object localObject27;
      try
      {
        ObjectInput localObjectInput30 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput30.readObject();
        localObject27 = localObjectInput30.readObject();
      }
      catch (IOException localIOException100)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException100);
      }
      catch (ClassNotFoundException localClassNotFoundException33)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException33);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject69 = localTerminateHookImpl.sfReplaceAttribute(localObject5, localObject27);
      try
      {
        ObjectOutput localObjectOutput29 = paramRemoteCall.getResultStream(true);
        localObjectOutput29.writeObject(localObject69);
      }
      catch (IOException localIOException76)
      {
        throw new MarshalException("error marshalling return", localIOException76);
      }
    case 46:
      try
      {
        ObjectInput localObjectInput17 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput17.readObject();
      }
      catch (IOException localIOException77)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException77);
      }
      catch (ClassNotFoundException localClassNotFoundException17)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException17);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject29 = localTerminateHookImpl.sfResolve((String)localObject5);
      try
      {
        ObjectOutput localObjectOutput22 = paramRemoteCall.getResultStream(true);
        localObjectOutput22.writeObject(localObject29);
      }
      catch (IOException localIOException51)
      {
        throw new MarshalException("error marshalling return", localIOException51);
      }
    case 47:
      Double localDouble1;
      Double localDouble3;
      boolean bool29;
      try
      {
        ObjectInput localObjectInput78 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput78.readObject();
        d1 = localObjectInput78.readDouble();
        localDouble1 = (Double)localObjectInput78.readObject();
        localDouble3 = (Double)localObjectInput78.readObject();
        bool29 = localObjectInput78.readBoolean();
      }
      catch (IOException localIOException186)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException186);
      }
      catch (ClassNotFoundException localClassNotFoundException81)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException81);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      double d5 = localTerminateHookImpl.sfResolve((String)localObject5, d1, localDouble1, localDouble3, bool29);
      try
      {
        ObjectOutput localObjectOutput75 = paramRemoteCall.getResultStream(true);
        localObjectOutput75.writeDouble(d5);
      }
      catch (IOException localIOException187)
      {
        throw new MarshalException("error marshalling return", localIOException187);
      }
    case 48:
      boolean bool19;
      try
      {
        ObjectInput localObjectInput70 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput70.readObject();
        d1 = localObjectInput70.readDouble();
        bool19 = localObjectInput70.readBoolean();
      }
      catch (IOException localIOException170)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException170);
      }
      catch (ClassNotFoundException localClassNotFoundException73)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException73);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      double d3 = localTerminateHookImpl.sfResolve((String)localObject5, d1, bool19);
      try
      {
        ObjectOutput localObjectOutput67 = paramRemoteCall.getResultStream(true);
        localObjectOutput67.writeDouble(d3);
      }
      catch (IOException localIOException171)
      {
        throw new MarshalException("error marshalling return", localIOException171);
      }
    case 49:
      Float localFloat1;
      Float localFloat3;
      boolean bool25;
      try
      {
        ObjectInput localObjectInput74 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput74.readObject();
        f1 = localObjectInput74.readFloat();
        localFloat1 = (Float)localObjectInput74.readObject();
        localFloat3 = (Float)localObjectInput74.readObject();
        bool25 = localObjectInput74.readBoolean();
      }
      catch (IOException localIOException182)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException182);
      }
      catch (ClassNotFoundException localClassNotFoundException77)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException77);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      float f5 = localTerminateHookImpl.sfResolve((String)localObject5, f1, localFloat1, localFloat3, bool25);
      try
      {
        ObjectOutput localObjectOutput68 = paramRemoteCall.getResultStream(true);
        localObjectOutput68.writeFloat(f5);
      }
      catch (IOException localIOException172)
      {
        throw new MarshalException("error marshalling return", localIOException172);
      }
    case 50:
      boolean bool13;
      try
      {
        ObjectInput localObjectInput40 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput40.readObject();
        f1 = localObjectInput40.readFloat();
        bool13 = localObjectInput40.readBoolean();
      }
      catch (IOException localIOException140)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException140);
      }
      catch (ClassNotFoundException localClassNotFoundException43)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException43);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      float f3 = localTerminateHookImpl.sfResolve((String)localObject5, f1, bool13);
      try
      {
        ObjectOutput localObjectOutput37 = paramRemoteCall.getResultStream(true);
        localObjectOutput37.writeFloat(f3);
      }
      catch (IOException localIOException101)
      {
        throw new MarshalException("error marshalling return", localIOException101);
      }
    case 51:
      Integer localInteger1;
      Integer localInteger2;
      boolean bool26;
      try
      {
        ObjectInput localObjectInput75 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput75.readObject();
        i = localObjectInput75.readInt();
        localInteger1 = (Integer)localObjectInput75.readObject();
        localInteger2 = (Integer)localObjectInput75.readObject();
        bool26 = localObjectInput75.readBoolean();
      }
      catch (IOException localIOException183)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException183);
      }
      catch (ClassNotFoundException localClassNotFoundException78)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException78);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      int n = localTerminateHookImpl.sfResolve((String)localObject5, i, localInteger1, localInteger2, bool26);
      try
      {
        ObjectOutput localObjectOutput69 = paramRemoteCall.getResultStream(true);
        localObjectOutput69.writeInt(n);
      }
      catch (IOException localIOException173)
      {
        throw new MarshalException("error marshalling return", localIOException173);
      }
    case 52:
      try
      {
        ObjectInput localObjectInput41 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput41.readObject();
        i = localObjectInput41.readInt();
        bool14 = localObjectInput41.readBoolean();
      }
      catch (IOException localIOException141)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException141);
      }
      catch (ClassNotFoundException localClassNotFoundException44)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException44);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      int k = localTerminateHookImpl.sfResolve((String)localObject5, i, bool14);
      try
      {
        ObjectOutput localObjectOutput38 = paramRemoteCall.getResultStream(true);
        localObjectOutput38.writeInt(k);
      }
      catch (IOException localIOException102)
      {
        throw new MarshalException("error marshalling return", localIOException102);
      }
    case 53:
      Long localLong1;
      Long localLong3;
      boolean bool30;
      try
      {
        ObjectInput localObjectInput79 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput79.readObject();
        l1 = localObjectInput79.readLong();
        localLong1 = (Long)localObjectInput79.readObject();
        localLong3 = (Long)localObjectInput79.readObject();
        bool30 = localObjectInput79.readBoolean();
      }
      catch (IOException localIOException188)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException188);
      }
      catch (ClassNotFoundException localClassNotFoundException82)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException82);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      long l5 = localTerminateHookImpl.sfResolve((String)localObject5, l1, localLong1, localLong3, bool30);
      try
      {
        ObjectOutput localObjectOutput76 = paramRemoteCall.getResultStream(true);
        localObjectOutput76.writeLong(l5);
      }
      catch (IOException localIOException189)
      {
        throw new MarshalException("error marshalling return", localIOException189);
      }
    case 54:
      boolean bool20;
      try
      {
        ObjectInput localObjectInput71 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput71.readObject();
        l1 = localObjectInput71.readLong();
        bool20 = localObjectInput71.readBoolean();
      }
      catch (IOException localIOException174)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException174);
      }
      catch (ClassNotFoundException localClassNotFoundException74)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException74);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      long l3 = localTerminateHookImpl.sfResolve((String)localObject5, l1, bool20);
      try
      {
        ObjectOutput localObjectOutput70 = paramRemoteCall.getResultStream(true);
        localObjectOutput70.writeLong(l3);
      }
      catch (IOException localIOException175)
      {
        throw new MarshalException("error marshalling return", localIOException175);
      }
    case 55:
      try
      {
        ObjectInput localObjectInput42 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput42.readObject();
        localObject30 = (File)localObjectInput42.readObject();
        bool14 = localObjectInput42.readBoolean();
      }
      catch (IOException localIOException142)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException142);
      }
      catch (ClassNotFoundException localClassNotFoundException45)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException45);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      File localFile1 = localTerminateHookImpl.sfResolve((String)localObject5, (File)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput39 = paramRemoteCall.getResultStream(true);
        localObjectOutput39.writeObject(localFile1);
      }
      catch (IOException localIOException103)
      {
        throw new MarshalException("error marshalling return", localIOException103);
      }
    case 56:
      try
      {
        ObjectInput localObjectInput43 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput43.readObject();
        localObject30 = localObjectInput43.readObject();
        bool14 = localObjectInput43.readBoolean();
      }
      catch (IOException localIOException143)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException143);
      }
      catch (ClassNotFoundException localClassNotFoundException46)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException46);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject106 = localTerminateHookImpl.sfResolve((String)localObject5, localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput40 = paramRemoteCall.getResultStream(true);
        localObjectOutput40.writeObject(localObject106);
      }
      catch (IOException localIOException104)
      {
        throw new MarshalException("error marshalling return", localIOException104);
      }
    case 57:
      try
      {
        ObjectInput localObjectInput44 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput44.readObject();
        localObject30 = (String)localObjectInput44.readObject();
        bool14 = localObjectInput44.readBoolean();
      }
      catch (IOException localIOException144)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException144);
      }
      catch (ClassNotFoundException localClassNotFoundException47)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException47);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      String str4 = localTerminateHookImpl.sfResolve((String)localObject5, (String)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput41 = paramRemoteCall.getResultStream(true);
        localObjectOutput41.writeObject(str4);
      }
      catch (IOException localIOException105)
      {
        throw new MarshalException("error marshalling return", localIOException105);
      }
    case 58:
      try
      {
        ObjectInput localObjectInput45 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput45.readObject();
        localObject30 = (InetAddress)localObjectInput45.readObject();
        bool14 = localObjectInput45.readBoolean();
      }
      catch (IOException localIOException145)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException145);
      }
      catch (ClassNotFoundException localClassNotFoundException48)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException48);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      InetAddress localInetAddress1 = localTerminateHookImpl.sfResolve((String)localObject5, (InetAddress)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput42 = paramRemoteCall.getResultStream(true);
        localObjectOutput42.writeObject(localInetAddress1);
      }
      catch (IOException localIOException106)
      {
        throw new MarshalException("error marshalling return", localIOException106);
      }
    case 59:
      try
      {
        ObjectInput localObjectInput46 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput46.readObject();
        localObject30 = (URL)localObjectInput46.readObject();
        bool14 = localObjectInput46.readBoolean();
      }
      catch (IOException localIOException146)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException146);
      }
      catch (ClassNotFoundException localClassNotFoundException49)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException49);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      URL localURL1 = localTerminateHookImpl.sfResolve((String)localObject5, (URL)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput43 = paramRemoteCall.getResultStream(true);
        localObjectOutput43.writeObject(localURL1);
      }
      catch (IOException localIOException107)
      {
        throw new MarshalException("error marshalling return", localIOException107);
      }
    case 60:
      try
      {
        ObjectInput localObjectInput47 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput47.readObject();
        localObject30 = (Vector)localObjectInput47.readObject();
        bool14 = localObjectInput47.readBoolean();
      }
      catch (IOException localIOException147)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException147);
      }
      catch (ClassNotFoundException localClassNotFoundException50)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException50);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Vector localVector1 = localTerminateHookImpl.sfResolve((String)localObject5, (Vector)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput44 = paramRemoteCall.getResultStream(true);
        localObjectOutput44.writeObject(localVector1);
      }
      catch (IOException localIOException108)
      {
        throw new MarshalException("error marshalling return", localIOException108);
      }
    case 61:
      try
      {
        ObjectInput localObjectInput48 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput48.readObject();
        localObject30 = (ComponentDescription)localObjectInput48.readObject();
        bool14 = localObjectInput48.readBoolean();
      }
      catch (IOException localIOException148)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException148);
      }
      catch (ClassNotFoundException localClassNotFoundException51)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException51);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      ComponentDescription localComponentDescription2 = localTerminateHookImpl.sfResolve((String)localObject5, (ComponentDescription)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput45 = paramRemoteCall.getResultStream(true);
        localObjectOutput45.writeObject(localComponentDescription2);
      }
      catch (IOException localIOException109)
      {
        throw new MarshalException("error marshalling return", localIOException109);
      }
    case 62:
      try
      {
        ObjectInput localObjectInput49 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput49.readObject();
        localObject30 = (Compound)localObjectInput49.readObject();
        bool14 = localObjectInput49.readBoolean();
      }
      catch (IOException localIOException149)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException149);
      }
      catch (ClassNotFoundException localClassNotFoundException52)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException52);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Compound localCompound1 = localTerminateHookImpl.sfResolve((String)localObject5, (Compound)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput46 = paramRemoteCall.getResultStream(true);
        localObjectOutput46.writeObject(localCompound1);
      }
      catch (IOException localIOException110)
      {
        throw new MarshalException("error marshalling return", localIOException110);
      }
    case 63:
      try
      {
        ObjectInput localObjectInput50 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput50.readObject();
        localObject30 = (Prim)localObjectInput50.readObject();
        bool14 = localObjectInput50.readBoolean();
      }
      catch (IOException localIOException150)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException150);
      }
      catch (ClassNotFoundException localClassNotFoundException53)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException53);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Prim localPrim4 = localTerminateHookImpl.sfResolve((String)localObject5, (Prim)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput47 = paramRemoteCall.getResultStream(true);
        localObjectOutput47.writeObject(localPrim4);
      }
      catch (IOException localIOException111)
      {
        throw new MarshalException("error marshalling return", localIOException111);
      }
    case 64:
      try
      {
        ObjectInput localObjectInput51 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput51.readObject();
        localObject30 = (Reference)localObjectInput51.readObject();
        bool14 = localObjectInput51.readBoolean();
      }
      catch (IOException localIOException151)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException151);
      }
      catch (ClassNotFoundException localClassNotFoundException54)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException54);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Reference localReference1 = localTerminateHookImpl.sfResolve((String)localObject5, (Reference)localObject30, bool14);
      try
      {
        ObjectOutput localObjectOutput48 = paramRemoteCall.getResultStream(true);
        localObjectOutput48.writeObject(localReference1);
      }
      catch (IOException localIOException112)
      {
        throw new MarshalException("error marshalling return", localIOException112);
      }
    case 65:
      try
      {
        ObjectInput localObjectInput31 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput31.readObject();
        bool8 = localObjectInput31.readBoolean();
      }
      catch (IOException localIOException113)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException113);
      }
      catch (ClassNotFoundException localClassNotFoundException34)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException34);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject72 = localTerminateHookImpl.sfResolve((String)localObject5, bool8);
      try
      {
        ObjectOutput localObjectOutput30 = paramRemoteCall.getResultStream(true);
        localObjectOutput30.writeObject(localObject72);
      }
      catch (IOException localIOException78)
      {
        throw new MarshalException("error marshalling return", localIOException78);
      }
    case 66:
      try
      {
        ObjectInput localObjectInput52 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput52.readObject();
        bool8 = localObjectInput52.readBoolean();
        bool15 = localObjectInput52.readBoolean();
      }
      catch (IOException localIOException152)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException152);
      }
      catch (ClassNotFoundException localClassNotFoundException55)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException55);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool21 = localTerminateHookImpl.sfResolve((String)localObject5, bool8, bool15);
      try
      {
        ObjectOutput localObjectOutput49 = paramRemoteCall.getResultStream(true);
        localObjectOutput49.writeBoolean(bool21);
      }
      catch (IOException localIOException114)
      {
        throw new MarshalException("error marshalling return", localIOException114);
      }
    case 67:
      String[] arrayOfString1;
      try
      {
        ObjectInput localObjectInput53 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput53.readObject();
        arrayOfString1 = (String[])localObjectInput53.readObject();
        bool15 = localObjectInput53.readBoolean();
      }
      catch (IOException localIOException153)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException153);
      }
      catch (ClassNotFoundException localClassNotFoundException56)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException56);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject118 = localTerminateHookImpl.sfResolve((String)localObject5, arrayOfString1, bool15);
      try
      {
        ObjectOutput localObjectOutput50 = paramRemoteCall.getResultStream(true);
        localObjectOutput50.writeObject(localObject118);
      }
      catch (IOException localIOException115)
      {
        throw new MarshalException("error marshalling return", localIOException115);
      }
    case 68:
      try
      {
        localObject118 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)((ObjectInput)localObject118).readObject();
      }
      catch (IOException localIOException79)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException79);
      }
      catch (ClassNotFoundException localClassNotFoundException18)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException18);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject32 = localTerminateHookImpl.sfResolve((Reference)localObject5);
      try
      {
        ObjectOutput localObjectOutput23 = paramRemoteCall.getResultStream(true);
        localObjectOutput23.writeObject(localObject32);
      }
      catch (IOException localIOException52)
      {
        throw new MarshalException("error marshalling return", localIOException52);
      }
    case 69:
      Double localDouble2;
      Double localDouble4;
      boolean bool31;
      try
      {
        ObjectInput localObjectInput80 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput80.readObject();
        d2 = localObjectInput80.readDouble();
        localDouble2 = (Double)localObjectInput80.readObject();
        localDouble4 = (Double)localObjectInput80.readObject();
        bool31 = localObjectInput80.readBoolean();
      }
      catch (IOException localIOException190)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException190);
      }
      catch (ClassNotFoundException localClassNotFoundException83)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException83);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      double d6 = localTerminateHookImpl.sfResolve((Reference)localObject5, d2, localDouble2, localDouble4, bool31);
      try
      {
        ObjectOutput localObjectOutput77 = paramRemoteCall.getResultStream(true);
        localObjectOutput77.writeDouble(d6);
      }
      catch (IOException localIOException191)
      {
        throw new MarshalException("error marshalling return", localIOException191);
      }
    case 70:
      boolean bool22;
      try
      {
        ObjectInput localObjectInput72 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput72.readObject();
        d2 = localObjectInput72.readDouble();
        bool22 = localObjectInput72.readBoolean();
      }
      catch (IOException localIOException176)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException176);
      }
      catch (ClassNotFoundException localClassNotFoundException75)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException75);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      double d4 = localTerminateHookImpl.sfResolve((Reference)localObject5, d2, bool22);
      try
      {
        ObjectOutput localObjectOutput71 = paramRemoteCall.getResultStream(true);
        localObjectOutput71.writeDouble(d4);
      }
      catch (IOException localIOException177)
      {
        throw new MarshalException("error marshalling return", localIOException177);
      }
    case 71:
      Float localFloat2;
      Float localFloat4;
      boolean bool27;
      try
      {
        ObjectInput localObjectInput76 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput76.readObject();
        f2 = localObjectInput76.readFloat();
        localFloat2 = (Float)localObjectInput76.readObject();
        localFloat4 = (Float)localObjectInput76.readObject();
        bool27 = localObjectInput76.readBoolean();
      }
      catch (IOException localIOException184)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException184);
      }
      catch (ClassNotFoundException localClassNotFoundException79)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException79);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      float f6 = localTerminateHookImpl.sfResolve((Reference)localObject5, f2, localFloat2, localFloat4, bool27);
      try
      {
        ObjectOutput localObjectOutput72 = paramRemoteCall.getResultStream(true);
        localObjectOutput72.writeFloat(f6);
      }
      catch (IOException localIOException178)
      {
        throw new MarshalException("error marshalling return", localIOException178);
      }
    case 72:
      boolean bool16;
      try
      {
        ObjectInput localObjectInput54 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput54.readObject();
        f2 = localObjectInput54.readFloat();
        bool16 = localObjectInput54.readBoolean();
      }
      catch (IOException localIOException154)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException154);
      }
      catch (ClassNotFoundException localClassNotFoundException57)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException57);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      float f4 = localTerminateHookImpl.sfResolve((Reference)localObject5, f2, bool16);
      try
      {
        ObjectOutput localObjectOutput51 = paramRemoteCall.getResultStream(true);
        localObjectOutput51.writeFloat(f4);
      }
      catch (IOException localIOException116)
      {
        throw new MarshalException("error marshalling return", localIOException116);
      }
    case 73:
      try
      {
        ObjectInput localObjectInput32 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput32.readObject();
        j = localObjectInput32.readInt();
      }
      catch (IOException localIOException117)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException117);
      }
      catch (ClassNotFoundException localClassNotFoundException35)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException35);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject75 = localTerminateHookImpl.sfResolve((Reference)localObject5, j);
      try
      {
        ObjectOutput localObjectOutput31 = paramRemoteCall.getResultStream(true);
        localObjectOutput31.writeObject(localObject75);
      }
      catch (IOException localIOException80)
      {
        throw new MarshalException("error marshalling return", localIOException80);
      }
    case 74:
      Integer localInteger3;
      boolean bool28;
      try
      {
        ObjectInput localObjectInput77 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput77.readObject();
        j = localObjectInput77.readInt();
        localObject75 = (Integer)localObjectInput77.readObject();
        localInteger3 = (Integer)localObjectInput77.readObject();
        bool28 = localObjectInput77.readBoolean();
      }
      catch (IOException localIOException185)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException185);
      }
      catch (ClassNotFoundException localClassNotFoundException80)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException80);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      int i1 = localTerminateHookImpl.sfResolve((Reference)localObject5, j, (Integer)localObject75, localInteger3, bool28);
      try
      {
        ObjectOutput localObjectOutput73 = paramRemoteCall.getResultStream(true);
        localObjectOutput73.writeInt(i1);
      }
      catch (IOException localIOException179)
      {
        throw new MarshalException("error marshalling return", localIOException179);
      }
    case 75:
      try
      {
        ObjectInput localObjectInput55 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput55.readObject();
        j = localObjectInput55.readInt();
        bool17 = localObjectInput55.readBoolean();
      }
      catch (IOException localIOException155)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException155);
      }
      catch (ClassNotFoundException localClassNotFoundException58)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException58);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      int m = localTerminateHookImpl.sfResolve((Reference)localObject5, j, bool17);
      try
      {
        ObjectOutput localObjectOutput52 = paramRemoteCall.getResultStream(true);
        localObjectOutput52.writeInt(m);
      }
      catch (IOException localIOException118)
      {
        throw new MarshalException("error marshalling return", localIOException118);
      }
    case 76:
      Long localLong2;
      Long localLong4;
      boolean bool32;
      try
      {
        ObjectInput localObjectInput81 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput81.readObject();
        l2 = localObjectInput81.readLong();
        localLong2 = (Long)localObjectInput81.readObject();
        localLong4 = (Long)localObjectInput81.readObject();
        bool32 = localObjectInput81.readBoolean();
      }
      catch (IOException localIOException192)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException192);
      }
      catch (ClassNotFoundException localClassNotFoundException84)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException84);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      long l6 = localTerminateHookImpl.sfResolve((Reference)localObject5, l2, localLong2, localLong4, bool32);
      try
      {
        ObjectOutput localObjectOutput78 = paramRemoteCall.getResultStream(true);
        localObjectOutput78.writeLong(l6);
      }
      catch (IOException localIOException193)
      {
        throw new MarshalException("error marshalling return", localIOException193);
      }
    case 77:
      boolean bool23;
      try
      {
        ObjectInput localObjectInput73 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput73.readObject();
        l2 = localObjectInput73.readLong();
        bool23 = localObjectInput73.readBoolean();
      }
      catch (IOException localIOException180)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException180);
      }
      catch (ClassNotFoundException localClassNotFoundException76)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException76);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      long l4 = localTerminateHookImpl.sfResolve((Reference)localObject5, l2, bool23);
      try
      {
        ObjectOutput localObjectOutput74 = paramRemoteCall.getResultStream(true);
        localObjectOutput74.writeLong(l4);
      }
      catch (IOException localIOException181)
      {
        throw new MarshalException("error marshalling return", localIOException181);
      }
    case 78:
      try
      {
        ObjectInput localObjectInput56 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput56.readObject();
        localObject33 = (File)localObjectInput56.readObject();
        bool17 = localObjectInput56.readBoolean();
      }
      catch (IOException localIOException156)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException156);
      }
      catch (ClassNotFoundException localClassNotFoundException59)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException59);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      File localFile2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (File)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput53 = paramRemoteCall.getResultStream(true);
        localObjectOutput53.writeObject(localFile2);
      }
      catch (IOException localIOException119)
      {
        throw new MarshalException("error marshalling return", localIOException119);
      }
    case 79:
      try
      {
        ObjectInput localObjectInput57 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput57.readObject();
        localObject33 = localObjectInput57.readObject();
        bool17 = localObjectInput57.readBoolean();
      }
      catch (IOException localIOException157)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException157);
      }
      catch (ClassNotFoundException localClassNotFoundException60)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException60);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject124 = localTerminateHookImpl.sfResolve((Reference)localObject5, localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput54 = paramRemoteCall.getResultStream(true);
        localObjectOutput54.writeObject(localObject124);
      }
      catch (IOException localIOException120)
      {
        throw new MarshalException("error marshalling return", localIOException120);
      }
    case 80:
      try
      {
        ObjectInput localObjectInput58 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput58.readObject();
        localObject33 = (String)localObjectInput58.readObject();
        bool17 = localObjectInput58.readBoolean();
      }
      catch (IOException localIOException158)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException158);
      }
      catch (ClassNotFoundException localClassNotFoundException61)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException61);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      String str5 = localTerminateHookImpl.sfResolve((Reference)localObject5, (String)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput55 = paramRemoteCall.getResultStream(true);
        localObjectOutput55.writeObject(str5);
      }
      catch (IOException localIOException121)
      {
        throw new MarshalException("error marshalling return", localIOException121);
      }
    case 81:
      try
      {
        ObjectInput localObjectInput59 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput59.readObject();
        localObject33 = (InetAddress)localObjectInput59.readObject();
        bool17 = localObjectInput59.readBoolean();
      }
      catch (IOException localIOException159)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException159);
      }
      catch (ClassNotFoundException localClassNotFoundException62)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException62);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      InetAddress localInetAddress2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (InetAddress)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput56 = paramRemoteCall.getResultStream(true);
        localObjectOutput56.writeObject(localInetAddress2);
      }
      catch (IOException localIOException122)
      {
        throw new MarshalException("error marshalling return", localIOException122);
      }
    case 82:
      try
      {
        ObjectInput localObjectInput60 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput60.readObject();
        localObject33 = (URL)localObjectInput60.readObject();
        bool17 = localObjectInput60.readBoolean();
      }
      catch (IOException localIOException160)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException160);
      }
      catch (ClassNotFoundException localClassNotFoundException63)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException63);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      URL localURL2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (URL)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput57 = paramRemoteCall.getResultStream(true);
        localObjectOutput57.writeObject(localURL2);
      }
      catch (IOException localIOException123)
      {
        throw new MarshalException("error marshalling return", localIOException123);
      }
    case 83:
      try
      {
        ObjectInput localObjectInput61 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput61.readObject();
        localObject33 = (Vector)localObjectInput61.readObject();
        bool17 = localObjectInput61.readBoolean();
      }
      catch (IOException localIOException161)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException161);
      }
      catch (ClassNotFoundException localClassNotFoundException64)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException64);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Vector localVector2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (Vector)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput58 = paramRemoteCall.getResultStream(true);
        localObjectOutput58.writeObject(localVector2);
      }
      catch (IOException localIOException124)
      {
        throw new MarshalException("error marshalling return", localIOException124);
      }
    case 84:
      try
      {
        ObjectInput localObjectInput62 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput62.readObject();
        localObject33 = (ComponentDescription)localObjectInput62.readObject();
        bool17 = localObjectInput62.readBoolean();
      }
      catch (IOException localIOException162)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException162);
      }
      catch (ClassNotFoundException localClassNotFoundException65)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException65);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      ComponentDescription localComponentDescription3 = localTerminateHookImpl.sfResolve((Reference)localObject5, (ComponentDescription)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput59 = paramRemoteCall.getResultStream(true);
        localObjectOutput59.writeObject(localComponentDescription3);
      }
      catch (IOException localIOException125)
      {
        throw new MarshalException("error marshalling return", localIOException125);
      }
    case 85:
      try
      {
        ObjectInput localObjectInput63 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput63.readObject();
        localObject33 = (Compound)localObjectInput63.readObject();
        bool17 = localObjectInput63.readBoolean();
      }
      catch (IOException localIOException163)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException163);
      }
      catch (ClassNotFoundException localClassNotFoundException66)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException66);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Compound localCompound2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (Compound)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput60 = paramRemoteCall.getResultStream(true);
        localObjectOutput60.writeObject(localCompound2);
      }
      catch (IOException localIOException126)
      {
        throw new MarshalException("error marshalling return", localIOException126);
      }
    case 86:
      try
      {
        ObjectInput localObjectInput64 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput64.readObject();
        localObject33 = (Prim)localObjectInput64.readObject();
        bool17 = localObjectInput64.readBoolean();
      }
      catch (IOException localIOException164)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException164);
      }
      catch (ClassNotFoundException localClassNotFoundException67)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException67);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Prim localPrim5 = localTerminateHookImpl.sfResolve((Reference)localObject5, (Prim)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput61 = paramRemoteCall.getResultStream(true);
        localObjectOutput61.writeObject(localPrim5);
      }
      catch (IOException localIOException127)
      {
        throw new MarshalException("error marshalling return", localIOException127);
      }
    case 87:
      try
      {
        ObjectInput localObjectInput65 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput65.readObject();
        localObject33 = (Reference)localObjectInput65.readObject();
        bool17 = localObjectInput65.readBoolean();
      }
      catch (IOException localIOException165)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException165);
      }
      catch (ClassNotFoundException localClassNotFoundException68)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException68);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Reference localReference2 = localTerminateHookImpl.sfResolve((Reference)localObject5, (Reference)localObject33, bool17);
      try
      {
        ObjectOutput localObjectOutput62 = paramRemoteCall.getResultStream(true);
        localObjectOutput62.writeObject(localReference2);
      }
      catch (IOException localIOException128)
      {
        throw new MarshalException("error marshalling return", localIOException128);
      }
    case 88:
      try
      {
        ObjectInput localObjectInput33 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput33.readObject();
        bool9 = localObjectInput33.readBoolean();
      }
      catch (IOException localIOException129)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException129);
      }
      catch (ClassNotFoundException localClassNotFoundException36)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException36);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject77 = localTerminateHookImpl.sfResolve((Reference)localObject5, bool9);
      try
      {
        ObjectOutput localObjectOutput32 = paramRemoteCall.getResultStream(true);
        localObjectOutput32.writeObject(localObject77);
      }
      catch (IOException localIOException81)
      {
        throw new MarshalException("error marshalling return", localIOException81);
      }
    case 89:
      try
      {
        ObjectInput localObjectInput66 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput66.readObject();
        bool9 = localObjectInput66.readBoolean();
        bool18 = localObjectInput66.readBoolean();
      }
      catch (IOException localIOException166)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException166);
      }
      catch (ClassNotFoundException localClassNotFoundException69)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException69);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool24 = localTerminateHookImpl.sfResolve((Reference)localObject5, bool9, bool18);
      try
      {
        ObjectOutput localObjectOutput63 = paramRemoteCall.getResultStream(true);
        localObjectOutput63.writeBoolean(bool24);
      }
      catch (IOException localIOException130)
      {
        throw new MarshalException("error marshalling return", localIOException130);
      }
    case 90:
      String[] arrayOfString2;
      try
      {
        ObjectInput localObjectInput67 = paramRemoteCall.getInputStream();
        localObject5 = (Reference)localObjectInput67.readObject();
        arrayOfString2 = (String[])localObjectInput67.readObject();
        bool18 = localObjectInput67.readBoolean();
      }
      catch (IOException localIOException167)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException167);
      }
      catch (ClassNotFoundException localClassNotFoundException70)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException70);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject136 = localTerminateHookImpl.sfResolve((Reference)localObject5, arrayOfString2, bool18);
      try
      {
        ObjectOutput localObjectOutput64 = paramRemoteCall.getResultStream(true);
        localObjectOutput64.writeObject(localObject136);
      }
      catch (IOException localIOException131)
      {
        throw new MarshalException("error marshalling return", localIOException131);
      }
    case 91:
      try
      {
        localObject136 = paramRemoteCall.getInputStream();
        localObject5 = ((ObjectInput)localObject136).readObject();
      }
      catch (IOException localIOException82)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException82);
      }
      catch (ClassNotFoundException localClassNotFoundException19)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException19);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject35 = localTerminateHookImpl.sfResolveHere(localObject5);
      try
      {
        ObjectOutput localObjectOutput24 = paramRemoteCall.getResultStream(true);
        localObjectOutput24.writeObject(localObject35);
      }
      catch (IOException localIOException53)
      {
        throw new MarshalException("error marshalling return", localIOException53);
      }
    case 92:
      try
      {
        ObjectInput localObjectInput34 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput34.readObject();
        bool10 = localObjectInput34.readBoolean();
      }
      catch (IOException localIOException132)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException132);
      }
      catch (ClassNotFoundException localClassNotFoundException37)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException37);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject80 = localTerminateHookImpl.sfResolveHere(localObject5, bool10);
      try
      {
        ObjectOutput localObjectOutput33 = paramRemoteCall.getResultStream(true);
        localObjectOutput33.writeObject(localObject80);
      }
      catch (IOException localIOException83)
      {
        throw new MarshalException("error marshalling return", localIOException83);
      }
    case 93:
      try
      {
        ObjectInput localObjectInput35 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput35.readObject();
        bool10 = localObjectInput35.readBoolean();
      }
      catch (IOException localIOException133)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException133);
      }
      catch (ClassNotFoundException localClassNotFoundException38)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException38);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Object localObject82 = localTerminateHookImpl.sfResolveHereNonlocal(localObject5, bool10);
      try
      {
        ObjectOutput localObjectOutput34 = paramRemoteCall.getResultStream(true);
        localObjectOutput34.writeObject(localObject82);
      }
      catch (IOException localIOException84)
      {
        throw new MarshalException("error marshalling return", localIOException84);
      }
    case 94:
      paramRemoteCall.releaseInputStream();
      localObject5 = localTerminateHookImpl.sfResolveParent();
      try
      {
        ObjectOutput localObjectOutput11 = paramRemoteCall.getResultStream(true);
        localObjectOutput11.writeObject(localObject5);
      }
      catch (IOException localIOException31)
      {
        throw new MarshalException("error marshalling return", localIOException31);
      }
    case 95:
      try
      {
        ObjectInput localObjectInput18 = paramRemoteCall.getInputStream();
        localObject5 = (String)localObjectInput18.readObject();
      }
      catch (IOException localIOException85)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException85);
      }
      catch (ClassNotFoundException localClassNotFoundException20)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException20);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject37 = localTerminateHookImpl.sfResolveWithParser((String)localObject5);
      try
      {
        ObjectOutput localObjectOutput25 = paramRemoteCall.getResultStream(true);
        localObjectOutput25.writeObject(localObject37);
      }
      catch (IOException localIOException54)
      {
        throw new MarshalException("error marshalling return", localIOException54);
      }
    case 96:
      try
      {
        ObjectInput localObjectInput36 = paramRemoteCall.getInputStream();
        localObject5 = localObjectInput36.readObject();
        localObject37 = (Set)localObjectInput36.readObject();
      }
      catch (IOException localIOException134)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException134);
      }
      catch (ClassNotFoundException localClassNotFoundException39)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException39);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfSetTags(localObject5, (Set)localObject37);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException55)
      {
        throw new MarshalException("error marshalling return", localIOException55);
      }
    case 97:
      try
      {
        ObjectInput localObjectInput19 = paramRemoteCall.getInputStream();
        localObject5 = (Set)localObjectInput19.readObject();
      }
      catch (IOException localIOException86)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException86);
      }
      catch (ClassNotFoundException localClassNotFoundException21)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException21);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfSetTags((Set)localObject5);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException32)
      {
        throw new MarshalException("error marshalling return", localIOException32);
      }
    case 98:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfStart();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException6)
      {
        throw new MarshalException("error marshalling return", localIOException6);
      }
    case 99:
      try
      {
        ObjectInput localObjectInput20 = paramRemoteCall.getInputStream();
        localTerminationRecord = (TerminationRecord)localObjectInput20.readObject();
      }
      catch (IOException localIOException87)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException87);
      }
      catch (ClassNotFoundException localClassNotFoundException22)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException22);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfTerminate(localTerminationRecord);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException33)
      {
        throw new MarshalException("error marshalling return", localIOException33);
      }
    case 100:
      try
      {
        ObjectInput localObjectInput21 = paramRemoteCall.getInputStream();
        localTerminationRecord = (TerminationRecord)localObjectInput21.readObject();
      }
      catch (IOException localIOException88)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException88);
      }
      catch (ClassNotFoundException localClassNotFoundException23)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException23);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfTerminateQuietlyWith(localTerminationRecord);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException34)
      {
        throw new MarshalException("error marshalling return", localIOException34);
      }
    case 101:
      Prim localPrim2;
      try
      {
        ObjectInput localObjectInput37 = paramRemoteCall.getInputStream();
        localTerminationRecord = (TerminationRecord)localObjectInput37.readObject();
        localPrim2 = (Prim)localObjectInput37.readObject();
      }
      catch (IOException localIOException135)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException135);
      }
      catch (ClassNotFoundException localClassNotFoundException40)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException40);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfTerminatedWith(localTerminationRecord, localPrim2);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException56)
      {
        throw new MarshalException("error marshalling return", localIOException56);
      }
    case 102:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfUpdate();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException7)
      {
        throw new MarshalException("error marshalling return", localIOException7);
      }
    case 103:
      ComponentDescription localComponentDescription1;
      try
      {
        ObjectInput localObjectInput22 = paramRemoteCall.getInputStream();
        localComponentDescription1 = (ComponentDescription)localObjectInput22.readObject();
      }
      catch (IOException localIOException89)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException89);
      }
      catch (ClassNotFoundException localClassNotFoundException24)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException24);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localTerminateHookImpl.sfUpdateComponent(localComponentDescription1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException35)
      {
        throw new MarshalException("error marshalling return", localIOException35);
      }
    case 104:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfUpdateDeploy();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException8)
      {
        throw new MarshalException("error marshalling return", localIOException8);
      }
    case 105:
      paramRemoteCall.releaseInputStream();
      localTerminateHookImpl.sfUpdateStart();
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException9)
      {
        throw new MarshalException("error marshalling return", localIOException9);
      }
    case 106:
      Context localContext;
      try
      {
        ObjectInput localObjectInput23 = paramRemoteCall.getInputStream();
        localContext = (Context)localObjectInput23.readObject();
      }
      catch (IOException localIOException90)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException90);
      }
      catch (ClassNotFoundException localClassNotFoundException25)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException25);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      boolean bool11 = localTerminateHookImpl.sfUpdateWith(localContext);
      try
      {
        ObjectOutput localObjectOutput26 = paramRemoteCall.getResultStream(true);
        localObjectOutput26.writeBoolean(bool11);
      }
      catch (IOException localIOException57)
      {
        throw new MarshalException("error marshalling return", localIOException57);
      }
    case 107:
      paramRemoteCall.releaseInputStream();
      boolean bool2 = localTerminateHookImpl.sfValid();
      try
      {
        ObjectOutput localObjectOutput12 = paramRemoteCall.getResultStream(true);
        localObjectOutput12.writeBoolean(bool2);
      }
      catch (IOException localIOException36)
      {
        throw new MarshalException("error marshalling return", localIOException36);
      }
    case 108:
      paramRemoteCall.releaseInputStream();
      Iterator localIterator = localTerminateHookImpl.sfValues();
      try
      {
        ObjectOutput localObjectOutput13 = paramRemoteCall.getResultStream(true);
        localObjectOutput13.writeObject(localIterator);
      }
      catch (IOException localIOException37)
      {
        throw new MarshalException("error marshalling return", localIOException37);
      }
    default:
      throw new UnmarshalException("invalid method number");
    }
  }

  public Operation[] getOperations()
  {
    return (Operation[])operations.clone();
  }
}

/* Location:           /home/mnovak/tmp/terminate-hook/
 * Qualified Name:     org.jboss.smartfrog.utils.TerminateHookImpl_Skel
 * JD-Core Version:    0.6.0
 */