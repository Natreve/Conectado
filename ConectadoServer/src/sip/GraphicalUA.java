//package sip;
//
////Compiled from GraphicalUA.java (version 1.2 : 46.0, super bit)
//public class local.ua.GraphicalUA extends javax.swing.JFrame implements local.ua.UserAgentListener {
//
//// Field descriptor #253 Ljava/lang/String;
//final java.lang.String app_name = "mjUA (http://www.mjsip.org)";
//
//// Field descriptor #256 Lorg/zoolu/tools/Log;
//protected org.zoolu.tools.Log log;
//
//// Field descriptor #258 Lorg/zoolu/sip/provider/SipProvider;
//protected org.zoolu.sip.provider.SipProvider sip_provider;
//
//// Field descriptor #260 Llocal/ua/UserAgent;
//protected local.ua.UserAgent ua;
//
//// Field descriptor #262 Llocal/ua/UserAgentProfile;
//protected local.ua.UserAgentProfile ua_profile;
//
//// Field descriptor #264 I
//protected static final int NMAX_CONTACTS = 10;
//
//// Field descriptor #267 Llocal/ua/StringList;
//protected local.ua.StringList buddy_list;
//
//// Field descriptor #264 I
//private static final int W_Width = 320;
//
//// Field descriptor #264 I
//private static final int W_Height = 90;
//
//// Field descriptor #264 I
//private static final int C_Height = 30;
//
//// Field descriptor #253 Ljava/lang/String;
//final java.lang.String CALL_GIF = "call.gif";
//
//// Field descriptor #253 Ljava/lang/String;
//final java.lang.String HANGUP_GIF = "hangup.gif";
//
//// Field descriptor #277 Ljavax/swing/Icon;
//javax.swing.Icon icon_call;
//
//// Field descriptor #277 Ljavax/swing/Icon;
//javax.swing.Icon icon_hangup;
//
//// Field descriptor #280 Ljavax/swing/JPanel;
//javax.swing.JPanel jPanel1;
//
//// Field descriptor #280 Ljavax/swing/JPanel;
//javax.swing.JPanel jPanel2;
//
//// Field descriptor #280 Ljavax/swing/JPanel;
//javax.swing.JPanel jPanel3;
//
//// Field descriptor #280 Ljavax/swing/JPanel;
//javax.swing.JPanel jPanel4;
//
//// Field descriptor #285 Ljavax/swing/JComboBox;
//javax.swing.JComboBox jComboBox1;
//
//// Field descriptor #287 Ljava/awt/BorderLayout;
//java.awt.BorderLayout borderLayout1;
//
//// Field descriptor #287 Ljava/awt/BorderLayout;
//java.awt.BorderLayout borderLayout2;
//
//// Field descriptor #280 Ljavax/swing/JPanel;
//javax.swing.JPanel jPanel5;
//
//// Field descriptor #291 Ljava/awt/GridLayout;
//java.awt.GridLayout gridLayout2;
//
//// Field descriptor #291 Ljava/awt/GridLayout;
//java.awt.GridLayout gridLayout3;
//
//// Field descriptor #294 Ljavax/swing/JButton;
//javax.swing.JButton jButton1;
//
//// Field descriptor #294 Ljavax/swing/JButton;
//javax.swing.JButton jButton2;
//
//// Field descriptor #297 Ljavax/swing/ComboBoxEditor;
//javax.swing.ComboBoxEditor comboBoxEditor1;
//
//// Field descriptor #287 Ljava/awt/BorderLayout;
//java.awt.BorderLayout borderLayout3;
//
//// Field descriptor #300 Ljavax/swing/JTextField;
//javax.swing.JTextField display;
//
//// Field descriptor #253 Ljava/lang/String;
//protected static final java.lang.String UA_IDLE = "IDLE";
//
//// Field descriptor #253 Ljava/lang/String;
//protected static final java.lang.String UA_INCOMING_CALL = "INCOMING_CALL";
//
//// Field descriptor #253 Ljava/lang/String;
//protected static final java.lang.String UA_OUTGOING_CALL = "OUTGOING_CALL";
//
//// Field descriptor #253 Ljava/lang/String;
//protected static final java.lang.String UA_ONCALL = "ONCALL";
//
//// Field descriptor #253 Ljava/lang/String;
//java.lang.String call_state;
//
//// Method descriptor #307 (Ljava/lang/String;)V
//// Stack: 3, Locals: 2
//protected void changeStatus(java.lang.String arg0);
//  0  aload_0 [this]
//  1  aload_1 [arg0]
//  2  putfield local.ua.GraphicalUA.call_state : java.lang.String [1]
//  5  aload_0 [this]
//  6  new java.lang.StringBuffer [2]
//  9  dup
// 10  invokespecial java.lang.StringBuffer() [3]
// 13  ldc <String "state: "> [4]
// 15  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 18  aload_0 [this]
// 19  getfield local.ua.GraphicalUA.call_state : java.lang.String [1]
// 22  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 25  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 28  iconst_3
// 29  invokespecial local.ua.GraphicalUA.printLog(java.lang.String, int) : void [7]
// 32  return
//   Line numbers:
//     [pc: 0, line: 122]
//     [pc: 5, line: 123]
//     [pc: 32, line: 124]
//
//// Method descriptor #311 (Ljava/lang/String;)Z
//// Stack: 2, Locals: 2
//protected boolean statusIs(java.lang.String arg0);
// 0  aload_0 [this]
// 1  getfield local.ua.GraphicalUA.call_state : java.lang.String [1]
// 4  aload_1 [arg0]
// 5  invokevirtual java.lang.String.equals(java.lang.Object) : boolean [8]
// 8  ireturn
//   Line numbers:
//     [pc: 0, line: 128]
//
//// Method descriptor #313 ()Ljava/lang/String;
//// Stack: 1, Locals: 1
//protected java.lang.String getStatus();
// 0  aload_0 [this]
// 1  getfield local.ua.GraphicalUA.call_state : java.lang.String [1]
// 4  areturn
//   Line numbers:
//     [pc: 0, line: 133]
//
//// Method descriptor #315 (Lorg/zoolu/sip/provider/SipProvider;Llocal/ua/UserAgentProfile;)V
//// Stack: 6, Locals: 5
//public GraphicalUA(org.zoolu.sip.provider.SipProvider arg0, local.ua.UserAgentProfile arg1);
//   0  aload_0 [this]
//   1  invokespecial javax.swing.JFrame() [9]
//   4  aload_0 [this]
//   5  ldc <String "mjUA (http://www.mjsip.org)"> [10]
//   7  putfield local.ua.GraphicalUA.app_name : java.lang.String [11]
//  10  aload_0 [this]
//  11  ldc <String "call.gif"> [12]
//  13  putfield local.ua.GraphicalUA.CALL_GIF : java.lang.String [13]
//  16  aload_0 [this]
//  17  ldc <String "hangup.gif"> [14]
//  19  putfield local.ua.GraphicalUA.HANGUP_GIF : java.lang.String [15]
//  22  aload_0 [this]
//  23  new javax.swing.JPanel [16]
//  26  dup
//  27  invokespecial javax.swing.JPanel() [17]
//  30  putfield local.ua.GraphicalUA.jPanel1 : javax.swing.JPanel [18]
//  33  aload_0 [this]
//  34  new javax.swing.JPanel [16]
//  37  dup
//  38  invokespecial javax.swing.JPanel() [17]
//  41  putfield local.ua.GraphicalUA.jPanel2 : javax.swing.JPanel [19]
//  44  aload_0 [this]
//  45  new javax.swing.JPanel [16]
//  48  dup
//  49  invokespecial javax.swing.JPanel() [17]
//  52  putfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
//  55  aload_0 [this]
//  56  new javax.swing.JPanel [16]
//  59  dup
//  60  invokespecial javax.swing.JPanel() [17]
//  63  putfield local.ua.GraphicalUA.jPanel4 : javax.swing.JPanel [21]
//  66  aload_0 [this]
//  67  new javax.swing.JComboBox [22]
//  70  dup
//  71  invokespecial javax.swing.JComboBox() [23]
//  74  putfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
//  77  aload_0 [this]
//  78  new java.awt.BorderLayout [25]
//  81  dup
//  82  invokespecial java.awt.BorderLayout() [26]
//  85  putfield local.ua.GraphicalUA.borderLayout1 : java.awt.BorderLayout [27]
//  88  aload_0 [this]
//  89  new java.awt.BorderLayout [25]
//  92  dup
//  93  invokespecial java.awt.BorderLayout() [26]
//  96  putfield local.ua.GraphicalUA.borderLayout2 : java.awt.BorderLayout [28]
//  99  aload_0 [this]
// 100  new javax.swing.JPanel [16]
// 103  dup
// 104  invokespecial javax.swing.JPanel() [17]
// 107  putfield local.ua.GraphicalUA.jPanel5 : javax.swing.JPanel [29]
// 110  aload_0 [this]
// 111  new java.awt.GridLayout [30]
// 114  dup
// 115  invokespecial java.awt.GridLayout() [31]
// 118  putfield local.ua.GraphicalUA.gridLayout2 : java.awt.GridLayout [32]
// 121  aload_0 [this]
// 122  new java.awt.GridLayout [30]
// 125  dup
// 126  invokespecial java.awt.GridLayout() [31]
// 129  putfield local.ua.GraphicalUA.gridLayout3 : java.awt.GridLayout [33]
// 132  aload_0 [this]
// 133  new javax.swing.JButton [34]
// 136  dup
// 137  invokespecial javax.swing.JButton() [35]
// 140  putfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 143  aload_0 [this]
// 144  new javax.swing.JButton [34]
// 147  dup
// 148  invokespecial javax.swing.JButton() [35]
// 151  putfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 154  aload_0 [this]
// 155  new javax.swing.plaf.basic.BasicComboBoxEditor [38]
// 158  dup
// 159  invokespecial javax.swing.plaf.basic.BasicComboBoxEditor() [39]
// 162  putfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 165  aload_0 [this]
// 166  new java.awt.BorderLayout [25]
// 169  dup
// 170  invokespecial java.awt.BorderLayout() [26]
// 173  putfield local.ua.GraphicalUA.borderLayout3 : java.awt.BorderLayout [41]
// 176  aload_0 [this]
// 177  new javax.swing.JTextField [42]
// 180  dup
// 181  invokespecial javax.swing.JTextField() [43]
// 184  putfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 187  aload_0 [this]
// 188  ldc <String "IDLE"> [45]
// 190  putfield local.ua.GraphicalUA.call_state : java.lang.String [1]
// 193  aload_0 [this]
// 194  aload_1 [arg0]
// 195  putfield local.ua.GraphicalUA.sip_provider : org.zoolu.sip.provider.SipProvider [46]
// 198  aload_0 [this]
// 199  aload_2 [arg1]
// 200  putfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 203  aload_0 [this]
// 204  aload_1 [arg0]
// 205  invokevirtual org.zoolu.sip.provider.SipProvider.getLog() : org.zoolu.tools.Log [48]
// 208  putfield local.ua.GraphicalUA.log : org.zoolu.tools.Log [49]
// 211  aload_0 [this]
// 212  new local.ua.UserAgent [50]
// 215  dup
// 216  aload_1 [arg0]
// 217  aload_2 [arg1]
// 218  aload_0 [this]
// 219  invokespecial local.ua.UserAgent(org.zoolu.sip.provider.SipProvider, local.ua.UserAgentProfile, local.ua.UserAgentListener) [51]
// 222  putfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 225  aload_0 [this]
// 226  ldc <String "IDLE"> [45]
// 228  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 231  aload_2 [arg1]
// 232  pop
// 233  getstatic local.ua.UserAgentProfile.ua_jar : java.lang.String [54]
// 236  astore_3
// 237  aload_3
// 238  ifnull 312
// 241  aload_0 [this]
// 242  aload_3
// 243  new java.lang.StringBuffer [2]
// 246  dup
// 247  invokespecial java.lang.StringBuffer() [3]
// 250  aload_2 [arg1]
// 251  pop
// 252  getstatic local.ua.UserAgentProfile.media_path : java.lang.String [55]
// 255  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 258  ldc <String "call.gif"> [12]
// 260  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 263  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 266  invokestatic org.zoolu.tools.Archive.getJarURL(java.lang.String, java.lang.String) : java.net.URL [56]
// 269  invokestatic org.zoolu.tools.Archive.getImageIcon(java.net.URL) : javax.swing.ImageIcon [57]
// 272  putfield local.ua.GraphicalUA.icon_call : javax.swing.Icon [58]
// 275  aload_0 [this]
// 276  aload_3
// 277  new java.lang.StringBuffer [2]
// 280  dup
// 281  invokespecial java.lang.StringBuffer() [3]
// 284  aload_2 [arg1]
// 285  pop
// 286  getstatic local.ua.UserAgentProfile.media_path : java.lang.String [55]
// 289  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 292  ldc <String "hangup.gif"> [14]
// 294  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 297  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 300  invokestatic org.zoolu.tools.Archive.getJarURL(java.lang.String, java.lang.String) : java.net.URL [56]
// 303  invokestatic org.zoolu.tools.Archive.getImageIcon(java.net.URL) : javax.swing.ImageIcon [57]
// 306  putfield local.ua.GraphicalUA.icon_hangup : javax.swing.Icon [59]
// 309  goto 396
// 312  aload_0 [this]
// 313  new java.net.URL [60]
// 316  dup
// 317  new java.lang.StringBuffer [2]
// 320  dup
// 321  invokespecial java.lang.StringBuffer() [3]
// 324  aload_2 [arg1]
// 325  pop
// 326  getstatic local.ua.UserAgentProfile.media_path : java.lang.String [55]
// 329  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 332  ldc <String "call.gif"> [12]
// 334  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 337  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 340  invokespecial java.net.URL(java.lang.String) [61]
// 343  invokestatic org.zoolu.tools.Archive.getImageIcon(java.net.URL) : javax.swing.ImageIcon [57]
// 346  putfield local.ua.GraphicalUA.icon_call : javax.swing.Icon [58]
// 349  aload_0 [this]
// 350  new java.net.URL [60]
// 353  dup
// 354  new java.lang.StringBuffer [2]
// 357  dup
// 358  invokespecial java.lang.StringBuffer() [3]
// 361  aload_2 [arg1]
// 362  pop
// 363  getstatic local.ua.UserAgentProfile.media_path : java.lang.String [55]
// 366  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 369  ldc <String "hangup.gif"> [14]
// 371  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 374  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 377  invokespecial java.net.URL(java.lang.String) [61]
// 380  invokestatic org.zoolu.tools.Archive.getImageIcon(java.net.URL) : javax.swing.ImageIcon [57]
// 383  putfield local.ua.GraphicalUA.icon_hangup : javax.swing.Icon [59]
// 386  goto 396
// 389  astore 4
// 391  aload 4
// 393  invokevirtual java.net.MalformedURLException.printStackTrace() : void [63]
// 396  aload_2 [arg1]
// 397  pop
// 398  getstatic local.ua.UserAgentProfile.buddy_list_file : java.lang.String [64]
// 401  ifnull 481
// 404  aload_2 [arg1]
// 405  pop
// 406  getstatic local.ua.UserAgentProfile.buddy_list_file : java.lang.String [64]
// 409  ldc <String "http://"> [65]
// 411  invokevirtual java.lang.String.startsWith(java.lang.String) : boolean [66]
// 414  ifne 430
// 417  aload_2 [arg1]
// 418  pop
// 419  getstatic local.ua.UserAgentProfile.buddy_list_file : java.lang.String [64]
// 422  ldc <String "file:/"> [67]
// 424  invokevirtual java.lang.String.startsWith(java.lang.String) : boolean [66]
// 427  ifeq 481
// 430  aload_0 [this]
// 431  new local.ua.StringList [68]
// 434  dup
// 435  new java.net.URL [60]
// 438  dup
// 439  aload_2 [arg1]
// 440  pop
// 441  getstatic local.ua.UserAgentProfile.buddy_list_file : java.lang.String [64]
// 444  invokespecial java.net.URL(java.lang.String) [61]
// 447  invokespecial local.ua.StringList(java.net.URL) [69]
// 450  putfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 453  goto 497
// 456  astore 4
// 458  aload 4
// 460  invokevirtual java.net.MalformedURLException.printStackTrace() : void [63]
// 463  aload_0 [this]
// 464  new local.ua.StringList [68]
// 467  dup
// 468  aconst_null
// 469  checkcast java.lang.String [71]
// 472  invokespecial local.ua.StringList(java.lang.String) [72]
// 475  putfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 478  goto 497
// 481  aload_0 [this]
// 482  new local.ua.StringList [68]
// 485  dup
// 486  aload_2 [arg1]
// 487  pop
// 488  getstatic local.ua.UserAgentProfile.buddy_list_file : java.lang.String [64]
// 491  invokespecial local.ua.StringList(java.lang.String) [72]
// 494  putfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 497  aload_0 [this]
// 498  new javax.swing.JComboBox [22]
// 501  dup
// 502  aload_0 [this]
// 503  getfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 506  invokevirtual local.ua.StringList.getElements() : java.util.Vector [73]
// 509  invokespecial javax.swing.JComboBox(java.util.Vector) [74]
// 512  putfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 515  aload_0 [this]
// 516  invokespecial local.ua.GraphicalUA.jbInit() : void [75]
// 519  goto 529
// 522  astore 4
// 524  aload 4
// 526  invokevirtual java.lang.Exception.printStackTrace() : void [77]
// 529  aload_0 [this]
// 530  invokevirtual local.ua.GraphicalUA.run() : void [78]
// 533  return
//   Exception Table:
//     [pc: 312, pc: 386] -> 389 when : java.net.MalformedURLException
//     [pc: 430, pc: 453] -> 456 when : java.net.MalformedURLException
//     [pc: 515, pc: 519] -> 522 when : java.lang.Exception
//   Line numbers:
//     [pc: 0, line: 141]
//     [pc: 4, line: 47]
//     [pc: 10, line: 77]
//     [pc: 16, line: 78]
//     [pc: 22, line: 85]
//     [pc: 33, line: 86]
//     [pc: 44, line: 87]
//     [pc: 55, line: 88]
//     [pc: 66, line: 89]
//     [pc: 77, line: 90]
//     [pc: 88, line: 91]
//     [pc: 99, line: 92]
//     [pc: 110, line: 93]
//     [pc: 121, line: 94]
//     [pc: 132, line: 95]
//     [pc: 143, line: 96]
//     [pc: 154, line: 97]
//     [pc: 165, line: 98]
//     [pc: 176, line: 100]
//     [pc: 187, line: 117]
//     [pc: 193, line: 142]
//     [pc: 198, line: 143]
//     [pc: 203, line: 144]
//     [pc: 211, line: 146]
//     [pc: 225, line: 148]
//     [pc: 231, line: 149]
//     [pc: 237, line: 150]
//     [pc: 241, line: 151]
//     [pc: 275, line: 152]
//     [pc: 312, line: 156]
//     [pc: 349, line: 157]
//     [pc: 386, line: 159]
//     [pc: 396, line: 161]
//     [pc: 430, line: 163]
//     [pc: 453, line: 165]
//     [pc: 481, line: 167]
//     [pc: 497, line: 168]
//     [pc: 515, line: 172]
//     [pc: 519, line: 174]
//     [pc: 529, line: 181]
//     [pc: 533, line: 182]
//
//// Method descriptor #317 ()V
//// Stack: 6, Locals: 3
//private void jbInit() throws java.lang.Exception;
//   0  aload_0 [this]
//   1  sipush 320
//   4  bipush 90
//   6  invokevirtual local.ua.GraphicalUA.setSize(int, int) : void [79]
//   9  invokestatic java.awt.Toolkit.getDefaultToolkit() : java.awt.Toolkit [80]
//  12  invokevirtual java.awt.Toolkit.getScreenSize() : java.awt.Dimension [81]
//  15  astore_1
//  16  aload_0 [this]
//  17  invokevirtual local.ua.GraphicalUA.getSize() : java.awt.Dimension [82]
//  20  astore_2
//  21  aload_2
//  22  getfield java.awt.Dimension.height : int [83]
//  25  aload_1
//  26  getfield java.awt.Dimension.height : int [83]
//  29  if_icmple 40
//  32  aload_2
//  33  aload_1
//  34  getfield java.awt.Dimension.height : int [83]
//  37  putfield java.awt.Dimension.height : int [83]
//  40  aload_2
//  41  getfield java.awt.Dimension.width : int [84]
//  44  aload_1
//  45  getfield java.awt.Dimension.width : int [84]
//  48  if_icmple 59
//  51  aload_2
//  52  aload_1
//  53  getfield java.awt.Dimension.width : int [84]
//  56  putfield java.awt.Dimension.width : int [84]
//  59  aload_0 [this]
//  60  aload_1
//  61  getfield java.awt.Dimension.width : int [84]
//  64  aload_2
//  65  getfield java.awt.Dimension.width : int [84]
//  68  isub
//  69  iconst_2
//  70  idiv
//  71  bipush 40
//  73  isub
//  74  aload_1
//  75  getfield java.awt.Dimension.height : int [83]
//  78  aload_2
//  79  getfield java.awt.Dimension.height : int [83]
//  82  isub
//  83  iconst_2
//  84  idiv
//  85  bipush 40
//  87  isub
//  88  invokevirtual local.ua.GraphicalUA.setLocation(int, int) : void [85]
//  91  aload_0 [this]
//  92  iconst_0
//  93  invokevirtual local.ua.GraphicalUA.setResizable(boolean) : void [86]
//  96  aload_0 [this]
//  97  aload_0 [this]
//  98  getfield local.ua.GraphicalUA.sip_provider : org.zoolu.sip.provider.SipProvider [46]
// 101  aload_0 [this]
// 102  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 105  getfield local.ua.UserAgentProfile.user : java.lang.String [87]
// 108  invokevirtual org.zoolu.sip.provider.SipProvider.getContactAddress(java.lang.String) : org.zoolu.sip.address.SipURL [88]
// 111  invokevirtual org.zoolu.sip.address.SipURL.toString() : java.lang.String [89]
// 114  invokevirtual local.ua.GraphicalUA.setTitle(java.lang.String) : void [90]
// 117  aload_0 [this]
// 118  new local.ua.GraphicalUA$1 [91]
// 121  dup
// 122  aload_0 [this]
// 123  invokespecial local.ua.GraphicalUA$1(local.ua.GraphicalUA) [92]
// 126  invokevirtual local.ua.GraphicalUA.addWindowListener(java.awt.event.WindowListener) : void [93]
// 129  aload_0 [this]
// 130  getfield local.ua.GraphicalUA.jPanel1 : javax.swing.JPanel [18]
// 133  aload_0 [this]
// 134  getfield local.ua.GraphicalUA.borderLayout3 : java.awt.BorderLayout [41]
// 137  invokevirtual javax.swing.JPanel.setLayout(java.awt.LayoutManager) : void [94]
// 140  aload_0 [this]
// 141  getfield local.ua.GraphicalUA.jPanel2 : javax.swing.JPanel [19]
// 144  aload_0 [this]
// 145  getfield local.ua.GraphicalUA.borderLayout2 : java.awt.BorderLayout [28]
// 148  invokevirtual javax.swing.JPanel.setLayout(java.awt.LayoutManager) : void [94]
// 151  aload_0 [this]
// 152  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 155  getstatic java.awt.Color.black : java.awt.Color [95]
// 158  invokevirtual javax.swing.JTextField.setBackground(java.awt.Color) : void [96]
// 161  aload_0 [this]
// 162  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 165  getstatic java.awt.Color.green : java.awt.Color [97]
// 168  invokevirtual javax.swing.JTextField.setForeground(java.awt.Color) : void [98]
// 171  aload_0 [this]
// 172  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 175  iconst_0
// 176  invokevirtual javax.swing.JTextField.setEditable(boolean) : void [99]
// 179  aload_0 [this]
// 180  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 183  ldc <String "mjUA (http://www.mjsip.org)"> [10]
// 185  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 188  aload_0 [this]
// 189  getfield local.ua.GraphicalUA.jPanel4 : javax.swing.JPanel [21]
// 192  aload_0 [this]
// 193  getfield local.ua.GraphicalUA.borderLayout1 : java.awt.BorderLayout [27]
// 196  invokevirtual javax.swing.JPanel.setLayout(java.awt.LayoutManager) : void [94]
// 199  aload_0 [this]
// 200  getfield local.ua.GraphicalUA.jPanel5 : javax.swing.JPanel [29]
// 203  aload_0 [this]
// 204  getfield local.ua.GraphicalUA.gridLayout2 : java.awt.GridLayout [32]
// 207  invokevirtual javax.swing.JPanel.setLayout(java.awt.LayoutManager) : void [94]
// 210  aload_0 [this]
// 211  getfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
// 214  aload_0 [this]
// 215  getfield local.ua.GraphicalUA.gridLayout3 : java.awt.GridLayout [33]
// 218  invokevirtual javax.swing.JPanel.setLayout(java.awt.LayoutManager) : void [94]
// 221  aload_0 [this]
// 222  getfield local.ua.GraphicalUA.gridLayout3 : java.awt.GridLayout [33]
// 225  iconst_2
// 226  invokevirtual java.awt.GridLayout.setRows(int) : void [101]
// 229  aload_0 [this]
// 230  getfield local.ua.GraphicalUA.gridLayout3 : java.awt.GridLayout [33]
// 233  iconst_1
// 234  invokevirtual java.awt.GridLayout.setColumns(int) : void [102]
// 237  aload_0 [this]
// 238  getfield local.ua.GraphicalUA.icon_call : javax.swing.Icon [58]
// 241  ifnull 270
// 244  aload_0 [this]
// 245  getfield local.ua.GraphicalUA.icon_call : javax.swing.Icon [58]
// 248  invokeinterface javax.swing.Icon.getIconWidth() : int [103] [nargs: 1]
// 253  ifle 270
// 256  aload_0 [this]
// 257  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 260  aload_0 [this]
// 261  getfield local.ua.GraphicalUA.icon_call : javax.swing.Icon [58]
// 264  invokevirtual javax.swing.JButton.setIcon(javax.swing.Icon) : void [104]
// 267  goto 279
// 270  aload_0 [this]
// 271  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 274  ldc <String "Call"> [105]
// 276  invokevirtual javax.swing.JButton.setText(java.lang.String) : void [106]
// 279  aload_0 [this]
// 280  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 283  new local.ua.GraphicalUA$2 [107]
// 286  dup
// 287  aload_0 [this]
// 288  invokespecial local.ua.GraphicalUA$2(local.ua.GraphicalUA) [108]
// 291  invokevirtual javax.swing.JButton.addActionListener(java.awt.event.ActionListener) : void [109]
// 294  aload_0 [this]
// 295  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 298  new local.ua.GraphicalUA$3 [110]
// 301  dup
// 302  aload_0 [this]
// 303  invokespecial local.ua.GraphicalUA$3(local.ua.GraphicalUA) [111]
// 306  invokevirtual javax.swing.JButton.addKeyListener(java.awt.event.KeyListener) : void [112]
// 309  aload_0 [this]
// 310  getfield local.ua.GraphicalUA.icon_hangup : javax.swing.Icon [59]
// 313  ifnull 342
// 316  aload_0 [this]
// 317  getfield local.ua.GraphicalUA.icon_hangup : javax.swing.Icon [59]
// 320  invokeinterface javax.swing.Icon.getIconWidth() : int [103] [nargs: 1]
// 325  ifle 342
// 328  aload_0 [this]
// 329  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 332  aload_0 [this]
// 333  getfield local.ua.GraphicalUA.icon_hangup : javax.swing.Icon [59]
// 336  invokevirtual javax.swing.JButton.setIcon(javax.swing.Icon) : void [104]
// 339  goto 351
// 342  aload_0 [this]
// 343  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 346  ldc <String "Hungup"> [113]
// 348  invokevirtual javax.swing.JButton.setText(java.lang.String) : void [106]
// 351  aload_0 [this]
// 352  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 355  new local.ua.GraphicalUA$4 [114]
// 358  dup
// 359  aload_0 [this]
// 360  invokespecial local.ua.GraphicalUA$4(local.ua.GraphicalUA) [115]
// 363  invokevirtual javax.swing.JButton.addActionListener(java.awt.event.ActionListener) : void [109]
// 366  aload_0 [this]
// 367  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 370  new local.ua.GraphicalUA$5 [116]
// 373  dup
// 374  aload_0 [this]
// 375  invokespecial local.ua.GraphicalUA$5(local.ua.GraphicalUA) [117]
// 378  invokevirtual javax.swing.JButton.addKeyListener(java.awt.event.KeyListener) : void [112]
// 381  aload_0 [this]
// 382  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 385  new local.ua.GraphicalUA$6 [118]
// 388  dup
// 389  aload_0 [this]
// 390  invokespecial local.ua.GraphicalUA$6(local.ua.GraphicalUA) [119]
// 393  invokevirtual javax.swing.JComboBox.addActionListener(java.awt.event.ActionListener) : void [120]
// 396  aload_0 [this]
// 397  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 400  new local.ua.GraphicalUA$7 [121]
// 403  dup
// 404  aload_0 [this]
// 405  invokespecial local.ua.GraphicalUA$7(local.ua.GraphicalUA) [122]
// 408  invokeinterface javax.swing.ComboBoxEditor.addActionListener(java.awt.event.ActionListener) : void [123] [nargs: 2]
// 413  aload_0 [this]
// 414  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 417  new java.awt.Font [124]
// 420  dup
// 421  ldc <String "Dialog"> [125]
// 423  iconst_0
// 424  bipush 10
// 426  invokespecial java.awt.Font(java.lang.String, int, int) [126]
// 429  invokevirtual javax.swing.JButton.setFont(java.awt.Font) : void [127]
// 432  aload_0 [this]
// 433  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 436  new java.awt.Font [124]
// 439  dup
// 440  ldc <String "Dialog"> [125]
// 442  iconst_0
// 443  bipush 10
// 445  invokespecial java.awt.Font(java.lang.String, int, int) [126]
// 448  invokevirtual javax.swing.JButton.setFont(java.awt.Font) : void [127]
// 451  aload_0 [this]
// 452  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 455  invokeinterface javax.swing.ComboBoxEditor.getEditorComponent() : java.awt.Component [128] [nargs: 1]
// 460  getstatic java.awt.Color.yellow : java.awt.Color [129]
// 463  invokevirtual java.awt.Component.setBackground(java.awt.Color) : void [130]
// 466  aload_0 [this]
// 467  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 470  iconst_1
// 471  invokevirtual javax.swing.JComboBox.setEditable(boolean) : void [131]
// 474  aload_0 [this]
// 475  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 478  aload_0 [this]
// 479  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 482  invokevirtual javax.swing.JComboBox.setEditor(javax.swing.ComboBoxEditor) : void [132]
// 485  aload_0 [this]
// 486  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 489  aconst_null
// 490  invokevirtual javax.swing.JComboBox.setSelectedItem(java.lang.Object) : void [133]
// 493  aload_0 [this]
// 494  getfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
// 497  new java.awt.Dimension [134]
// 500  dup
// 501  iconst_0
// 502  bipush 30
// 504  invokespecial java.awt.Dimension(int, int) [135]
// 507  invokevirtual javax.swing.JPanel.setPreferredSize(java.awt.Dimension) : void [136]
// 510  aload_0 [this]
// 511  invokevirtual local.ua.GraphicalUA.getContentPane() : java.awt.Container [137]
// 514  aload_0 [this]
// 515  getfield local.ua.GraphicalUA.jPanel1 : javax.swing.JPanel [18]
// 518  ldc <String "Center"> [138]
// 520  invokevirtual java.awt.Container.add(java.awt.Component, java.lang.Object) : void [139]
// 523  aload_0 [this]
// 524  getfield local.ua.GraphicalUA.jPanel1 : javax.swing.JPanel [18]
// 527  aload_0 [this]
// 528  getfield local.ua.GraphicalUA.jPanel2 : javax.swing.JPanel [19]
// 531  ldc <String "Center"> [138]
// 533  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 536  aload_0 [this]
// 537  getfield local.ua.GraphicalUA.jPanel1 : javax.swing.JPanel [18]
// 540  aload_0 [this]
// 541  getfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
// 544  ldc <String "South"> [141]
// 546  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 549  aload_0 [this]
// 550  getfield local.ua.GraphicalUA.jPanel2 : javax.swing.JPanel [19]
// 553  aload_0 [this]
// 554  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 557  ldc <String "Center"> [138]
// 559  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 562  aload_0 [this]
// 563  getfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
// 566  aload_0 [this]
// 567  getfield local.ua.GraphicalUA.jPanel4 : javax.swing.JPanel [21]
// 570  aconst_null
// 571  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 574  aload_0 [this]
// 575  getfield local.ua.GraphicalUA.jPanel3 : javax.swing.JPanel [20]
// 578  aload_0 [this]
// 579  getfield local.ua.GraphicalUA.jPanel5 : javax.swing.JPanel [29]
// 582  aconst_null
// 583  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 586  aload_0 [this]
// 587  getfield local.ua.GraphicalUA.jPanel4 : javax.swing.JPanel [21]
// 590  aload_0 [this]
// 591  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 594  ldc <String "Center"> [138]
// 596  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 599  aload_0 [this]
// 600  getfield local.ua.GraphicalUA.jPanel5 : javax.swing.JPanel [29]
// 603  aload_0 [this]
// 604  getfield local.ua.GraphicalUA.jButton1 : javax.swing.JButton [36]
// 607  aconst_null
// 608  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 611  aload_0 [this]
// 612  getfield local.ua.GraphicalUA.jPanel5 : javax.swing.JPanel [29]
// 615  aload_0 [this]
// 616  getfield local.ua.GraphicalUA.jButton2 : javax.swing.JButton [37]
// 619  aconst_null
// 620  invokevirtual javax.swing.JPanel.add(java.awt.Component, java.lang.Object) : void [140]
// 623  aload_0 [this]
// 624  iconst_1
// 625  invokevirtual local.ua.GraphicalUA.setVisible(boolean) : void [142]
// 628  return
//   Line numbers:
//     [pc: 0, line: 188]
//     [pc: 9, line: 189]
//     [pc: 16, line: 190]
//     [pc: 21, line: 191]
//     [pc: 40, line: 192]
//     [pc: 59, line: 193]
//     [pc: 91, line: 194]
//     [pc: 96, line: 196]
//     [pc: 117, line: 197]
//     [pc: 129, line: 200]
//     [pc: 140, line: 201]
//     [pc: 151, line: 202]
//     [pc: 161, line: 203]
//     [pc: 171, line: 204]
//     [pc: 179, line: 205]
//     [pc: 188, line: 206]
//     [pc: 199, line: 207]
//     [pc: 210, line: 208]
//     [pc: 221, line: 209]
//     [pc: 229, line: 210]
//     [pc: 237, line: 211]
//     [pc: 270, line: 212]
//     [pc: 279, line: 213]
//     [pc: 294, line: 216]
//     [pc: 309, line: 219]
//     [pc: 342, line: 220]
//     [pc: 351, line: 221]
//     [pc: 366, line: 224]
//     [pc: 381, line: 227]
//     [pc: 396, line: 230]
//     [pc: 413, line: 233]
//     [pc: 432, line: 234]
//     [pc: 451, line: 235]
//     [pc: 466, line: 236]
//     [pc: 474, line: 237]
//     [pc: 485, line: 238]
//     [pc: 493, line: 239]
//     [pc: 510, line: 240]
//     [pc: 523, line: 241]
//     [pc: 536, line: 242]
//     [pc: 549, line: 243]
//     [pc: 562, line: 244]
//     [pc: 574, line: 245]
//     [pc: 586, line: 246]
//     [pc: 599, line: 247]
//     [pc: 611, line: 248]
//     [pc: 623, line: 251]
//     [pc: 628, line: 252]
//
//// Method descriptor #317 ()V
//// Stack: 5, Locals: 1
//void run();
//   0  aload_0 [this]
//   1  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//   4  getfield local.ua.UserAgentProfile.re_invite_time : int [143]
//   7  ifle 21
//  10  aload_0 [this]
//  11  aload_0 [this]
//  12  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  15  getfield local.ua.UserAgentProfile.re_invite_time : int [143]
//  18  invokevirtual local.ua.GraphicalUA.reInvite(int) : void [144]
//  21  aload_0 [this]
//  22  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  25  getfield local.ua.UserAgentProfile.transfer_to : org.zoolu.sip.address.NameAddress [145]
//  28  ifnull 59
//  31  aload_0 [this]
//  32  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  35  getfield local.ua.UserAgentProfile.transfer_time : int [146]
//  38  ifle 59
//  41  aload_0 [this]
//  42  aload_0 [this]
//  43  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  46  getfield local.ua.UserAgentProfile.transfer_to : org.zoolu.sip.address.NameAddress [145]
//  49  aload_0 [this]
//  50  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  53  getfield local.ua.UserAgentProfile.transfer_time : int [146]
//  56  invokevirtual local.ua.GraphicalUA.callTransfer(org.zoolu.sip.address.NameAddress, int) : void [147]
//  59  aload_0 [this]
//  60  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  63  getfield local.ua.UserAgentProfile.do_unregister_all : boolean [148]
//  66  ifeq 85
//  69  aload_0 [this]
//  70  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
//  73  ldc <String "UNREGISTER ALL contact URLs"> [149]
//  75  invokevirtual local.ua.UserAgent.printLog(java.lang.String) : void [150]
//  78  aload_0 [this]
//  79  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
//  82  invokevirtual local.ua.UserAgent.unregisterall() : void [151]
//  85  aload_0 [this]
//  86  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  89  getfield local.ua.UserAgentProfile.do_unregister : boolean [152]
//  92  ifeq 111
//  95  aload_0 [this]
//  96  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
//  99  ldc <String "UNREGISTER the contact URL"> [153]
// 101  invokevirtual local.ua.UserAgent.printLog(java.lang.String) : void [150]
// 104  aload_0 [this]
// 105  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 108  invokevirtual local.ua.UserAgent.unregister() : void [154]
// 111  aload_0 [this]
// 112  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 115  getfield local.ua.UserAgentProfile.do_register : boolean [155]
// 118  ifeq 160
// 121  aload_0 [this]
// 122  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 125  ldc <String "REGISTRATION"> [156]
// 127  invokevirtual local.ua.UserAgent.printLog(java.lang.String) : void [150]
// 130  aload_0 [this]
// 131  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 134  aload_0 [this]
// 135  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 138  getfield local.ua.UserAgentProfile.expires : int [157]
// 141  aload_0 [this]
// 142  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 145  getfield local.ua.UserAgentProfile.expires : int [157]
// 148  iconst_2
// 149  idiv
// 150  aload_0 [this]
// 151  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 154  getfield local.ua.UserAgentProfile.keepalive_time : long [158]
// 157  invokevirtual local.ua.UserAgent.loopRegister(int, int, long) : void [159]
// 160  aload_0 [this]
// 161  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 164  getfield local.ua.UserAgentProfile.call_to : org.zoolu.sip.address.NameAddress [160]
// 167  ifnull 281
// 170  aload_0 [this]
// 171  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 174  new java.lang.StringBuffer [2]
// 177  dup
// 178  invokespecial java.lang.StringBuffer() [3]
// 181  ldc <String "UAC: CALLING "> [161]
// 183  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 186  aload_0 [this]
// 187  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 190  getfield local.ua.UserAgentProfile.call_to : org.zoolu.sip.address.NameAddress [160]
// 193  invokevirtual java.lang.StringBuffer.append(java.lang.Object) : java.lang.StringBuffer [162]
// 196  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 199  invokevirtual local.ua.UserAgent.printLog(java.lang.String) : void [150]
// 202  aload_0 [this]
// 203  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 206  aconst_null
// 207  invokevirtual javax.swing.JComboBox.setSelectedItem(java.lang.Object) : void [133]
// 210  aload_0 [this]
// 211  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 214  aload_0 [this]
// 215  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 218  getfield local.ua.UserAgentProfile.call_to : org.zoolu.sip.address.NameAddress [160]
// 221  invokevirtual org.zoolu.sip.address.NameAddress.toString() : java.lang.String [163]
// 224  invokeinterface javax.swing.ComboBoxEditor.setItem(java.lang.Object) : void [164] [nargs: 2]
// 229  aload_0 [this]
// 230  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 233  new java.lang.StringBuffer [2]
// 236  dup
// 237  invokespecial java.lang.StringBuffer() [3]
// 240  ldc <String "CALLING "> [165]
// 242  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 245  aload_0 [this]
// 246  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 249  getfield local.ua.UserAgentProfile.call_to : org.zoolu.sip.address.NameAddress [160]
// 252  invokevirtual java.lang.StringBuffer.append(java.lang.Object) : java.lang.StringBuffer [162]
// 255  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 258  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 261  aload_0 [this]
// 262  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 265  aload_0 [this]
// 266  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 269  getfield local.ua.UserAgentProfile.call_to : org.zoolu.sip.address.NameAddress [160]
// 272  invokevirtual local.ua.UserAgent.call(org.zoolu.sip.address.NameAddress) : void [166]
// 275  aload_0 [this]
// 276  ldc <String "OUTGOING_CALL"> [167]
// 278  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 281  aload_0 [this]
// 282  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 285  getfield local.ua.UserAgentProfile.audio : boolean [168]
// 288  ifne 310
// 291  aload_0 [this]
// 292  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 295  getfield local.ua.UserAgentProfile.video : boolean [169]
// 298  ifne 310
// 301  aload_0 [this]
// 302  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 305  ldc <String "ONLY SIGNALING, NO MEDIA"> [170]
// 307  invokevirtual local.ua.UserAgent.printLog(java.lang.String) : void [150]
// 310  return
//   Line numbers:
//     [pc: 0, line: 260]
//     [pc: 10, line: 261]
//     [pc: 21, line: 265]
//     [pc: 41, line: 266]
//     [pc: 59, line: 269]
//     [pc: 69, line: 271]
//     [pc: 78, line: 272]
//     [pc: 85, line: 275]
//     [pc: 95, line: 277]
//     [pc: 104, line: 278]
//     [pc: 111, line: 281]
//     [pc: 121, line: 283]
//     [pc: 130, line: 284]
//     [pc: 160, line: 287]
//     [pc: 170, line: 289]
//     [pc: 202, line: 290]
//     [pc: 210, line: 291]
//     [pc: 229, line: 292]
//     [pc: 261, line: 293]
//     [pc: 275, line: 294]
//     [pc: 281, line: 297]
//     [pc: 310, line: 298]
//
//// Method descriptor #317 ()V
//// Stack: 1, Locals: 1
//protected void exit();
// 0  aload_0 [this]
// 1  invokevirtual local.ua.GraphicalUA.jButton2_actionPerformed() : void [171]
// 4  iconst_0
// 5  invokestatic java.lang.System.exit(int) : void [172]
// 8  return
//   Line numbers:
//     [pc: 0, line: 304]
//     [pc: 4, line: 306]
//     [pc: 8, line: 307]
//
//// Method descriptor #317 ()V
//// Stack: 3, Locals: 2
//void jButton1_actionPerformed();
//   0  aload_0 [this]
//   1  ldc <String "IDLE"> [45]
//   3  invokevirtual local.ua.GraphicalUA.statusIs(java.lang.String) : boolean [173]
//   6  ifeq 104
//   9  aload_0 [this]
//  10  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
//  13  invokeinterface javax.swing.ComboBoxEditor.getItem() : java.lang.Object [174] [nargs: 1]
//  18  checkcast java.lang.String [71]
//  21  astore_1
//  22  aload_1
//  23  ifnull 135
//  26  aload_1
//  27  invokevirtual java.lang.String.length() : int [175]
//  30  ifle 135
//  33  aload_0 [this]
//  34  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
//  37  invokevirtual local.ua.UserAgent.hangup() : void [176]
//  40  aload_0 [this]
//  41  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  44  new java.lang.StringBuffer [2]
//  47  dup
//  48  invokespecial java.lang.StringBuffer() [3]
//  51  ldc <String "CALLING "> [165]
//  53  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
//  56  aload_1
//  57  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
//  60  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
//  63  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  66  aload_0 [this]
//  67  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
//  70  aload_1
//  71  invokevirtual local.ua.UserAgent.call(java.lang.String) : void [177]
//  74  aload_0 [this]
//  75  ldc <String "OUTGOING_CALL"> [167]
//  77  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
//  80  aload_0 [this]
//  81  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  84  getfield local.ua.UserAgentProfile.hangup_time : int [178]
//  87  ifle 135
//  90  aload_0 [this]
//  91  aload_0 [this]
//  92  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  95  getfield local.ua.UserAgentProfile.hangup_time : int [178]
//  98  invokevirtual local.ua.GraphicalUA.automaticHangup(int) : void [179]
// 101  goto 135
// 104  aload_0 [this]
// 105  ldc <String "INCOMING_CALL"> [180]
// 107  invokevirtual local.ua.GraphicalUA.statusIs(java.lang.String) : boolean [173]
// 110  ifeq 135
// 113  aload_0 [this]
// 114  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 117  invokevirtual local.ua.UserAgent.accept() : void [181]
// 120  aload_0 [this]
// 121  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 124  ldc <String "ON CALL"> [182]
// 126  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 129  aload_0 [this]
// 130  ldc <String "ONCALL"> [183]
// 132  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 135  return
//   Line numbers:
//     [pc: 0, line: 313]
//     [pc: 9, line: 314]
//     [pc: 22, line: 315]
//     [pc: 33, line: 316]
//     [pc: 40, line: 317]
//     [pc: 66, line: 318]
//     [pc: 74, line: 319]
//     [pc: 80, line: 320]
//     [pc: 104, line: 324]
//     [pc: 113, line: 325]
//     [pc: 120, line: 326]
//     [pc: 129, line: 327]
//     [pc: 135, line: 329]
//
//// Method descriptor #317 ()V
//// Stack: 2, Locals: 1
//void jButton2_actionPerformed();
//  0  aload_0 [this]
//  1  ldc <String "IDLE"> [45]
//  3  invokevirtual local.ua.GraphicalUA.statusIs(java.lang.String) : boolean [173]
//  6  ifne 31
//  9  aload_0 [this]
// 10  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 13  invokevirtual local.ua.UserAgent.hangup() : void [176]
// 16  aload_0 [this]
// 17  ldc <String "IDLE"> [45]
// 19  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 22  aload_0 [this]
// 23  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 26  ldc <String "HANGUP"> [184]
// 28  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 31  return
//   Line numbers:
//     [pc: 0, line: 335]
//     [pc: 9, line: 336]
//     [pc: 16, line: 338]
//     [pc: 22, line: 340]
//     [pc: 31, line: 342]
//
//// Method descriptor #324 (Ljava/awt/event/ActionEvent;)V
//// Stack: 0, Locals: 2
//void jComboBox1_actionPerformed(java.awt.event.ActionEvent arg0);
// 0  return
//   Line numbers:
//     [pc: 0, line: 355]
//
//// Method descriptor #324 (Ljava/awt/event/ActionEvent;)V
//// Stack: 3, Locals: 4
//void comboBoxEditor1_actionPerformed(java.awt.event.ActionEvent arg0);
//   0  aload_0 [this]
//   1  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
//   4  invokeinterface javax.swing.ComboBoxEditor.getItem() : java.lang.Object [174] [nargs: 1]
//   9  checkcast java.lang.String [71]
//  12  astore_2
//  13  aload_2
//  14  ldc <String "\""> [185]
//  16  invokevirtual java.lang.String.indexOf(java.lang.String) : int [186]
//  19  ifge 31
//  22  aload_2
//  23  ldc <String "<"> [187]
//  25  invokevirtual java.lang.String.indexOf(java.lang.String) : int [186]
//  28  iflt 60
//  31  new org.zoolu.sip.provider.SipParser [188]
//  34  dup
//  35  aload_2
//  36  invokespecial org.zoolu.sip.provider.SipParser(java.lang.String) [189]
//  39  invokevirtual org.zoolu.sip.provider.SipParser.getNameAddress() : org.zoolu.sip.address.NameAddress [190]
//  42  astore_3
//  43  aload_3
//  44  ifnull 55
//  47  aload_3
//  48  invokevirtual org.zoolu.sip.address.NameAddress.toString() : java.lang.String [163]
//  51  astore_2
//  52  goto 83
//  55  aconst_null
//  56  astore_2
//  57  goto 83
//  60  new org.zoolu.sip.address.SipURL [191]
//  63  dup
//  64  aload_2
//  65  invokespecial org.zoolu.sip.address.SipURL(java.lang.String) [192]
//  68  astore_3
//  69  aload_3
//  70  ifnull 81
//  73  aload_3
//  74  invokevirtual org.zoolu.sip.address.SipURL.toString() : java.lang.String [89]
//  77  astore_2
//  78  goto 83
//  81  aconst_null
//  82  astore_2
//  83  aload_2
//  84  ifnonnull 124
//  87  getstatic java.lang.System.out : java.io.PrintStream [193]
//  90  new java.lang.StringBuffer [2]
//  93  dup
//  94  invokespecial java.lang.StringBuffer() [3]
//  97  ldc <String "DEBUG: No sip url recognized in: "> [194]
//  99  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 102  aload_0 [this]
// 103  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 106  invokeinterface javax.swing.ComboBoxEditor.getItem() : java.lang.Object [174] [nargs: 1]
// 111  checkcast java.lang.String [71]
// 114  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 117  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 120  invokevirtual java.io.PrintStream.println(java.lang.String) : void [195]
// 123  return
// 124  aload_0 [this]
// 125  getfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 128  aload_2
// 129  invokevirtual local.ua.StringList.contains(java.lang.String) : boolean [196]
// 132  ifne 189
// 135  aload_0 [this]
// 136  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 139  aload_2
// 140  iconst_0
// 141  invokevirtual javax.swing.JComboBox.insertItemAt(java.lang.Object, int) : void [197]
// 144  aload_0 [this]
// 145  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 148  iconst_0
// 149  invokevirtual javax.swing.JComboBox.setSelectedIndex(int) : void [198]
// 152  aload_0 [this]
// 153  getfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 156  invokevirtual local.ua.StringList.getElements() : java.util.Vector [73]
// 159  invokevirtual java.util.Vector.size() : int [199]
// 162  bipush 10
// 164  if_icmple 179
// 167  aload_0 [this]
// 168  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 171  bipush 10
// 173  invokevirtual javax.swing.JComboBox.removeItemAt(int) : void [200]
// 176  goto 152
// 179  aload_0 [this]
// 180  getfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 183  invokevirtual local.ua.StringList.save() : void [201]
// 186  goto 206
// 189  aload_0 [this]
// 190  getfield local.ua.GraphicalUA.buddy_list : local.ua.StringList [70]
// 193  aload_2
// 194  invokevirtual local.ua.StringList.indexOf(java.lang.String) : int [202]
// 197  istore_3
// 198  aload_0 [this]
// 199  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 202  iload_3
// 203  invokevirtual javax.swing.JComboBox.setSelectedIndex(int) : void [198]
// 206  return
//   Line numbers:
//     [pc: 0, line: 362]
//     [pc: 13, line: 364]
//     [pc: 31, line: 366]
//     [pc: 43, line: 367]
//     [pc: 55, line: 368]
//     [pc: 60, line: 372]
//     [pc: 69, line: 373]
//     [pc: 81, line: 374]
//     [pc: 83, line: 377]
//     [pc: 87, line: 378]
//     [pc: 123, line: 379]
//     [pc: 124, line: 383]
//     [pc: 135, line: 384]
//     [pc: 144, line: 385]
//     [pc: 152, line: 387]
//     [pc: 179, line: 389]
//     [pc: 189, line: 392]
//     [pc: 198, line: 393]
//     [pc: 206, line: 396]
//
//// Method descriptor #327 (Llocal/ua/UserAgent;Lorg/zoolu/sip/address/NameAddress;Lorg/zoolu/sip/address/NameAddress;Ljava/util/Vector;)V
//// Stack: 3, Locals: 5
//public void onUaIncomingCall(local.ua.UserAgent arg0, org.zoolu.sip.address.NameAddress arg1, org.zoolu.sip.address.NameAddress arg2, java.util.Vector arg3);
//   0  aload_0 [this]
//   1  ldc <String "INCOMING_CALL"> [180]
//   3  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
//   6  aload_0 [this]
//   7  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  10  getfield local.ua.UserAgentProfile.redirect_to : org.zoolu.sip.address.NameAddress [203]
//  13  ifnull 62
//  16  aload_0 [this]
//  17  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  20  new java.lang.StringBuffer [2]
//  23  dup
//  24  invokespecial java.lang.StringBuffer() [3]
//  27  ldc <String "CALL redirected to "> [204]
//  29  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
//  32  aload_0 [this]
//  33  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  36  getfield local.ua.UserAgentProfile.redirect_to : org.zoolu.sip.address.NameAddress [203]
//  39  invokevirtual java.lang.StringBuffer.append(java.lang.Object) : java.lang.StringBuffer [162]
//  42  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
//  45  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  48  aload_1 [arg0]
//  49  aload_0 [this]
//  50  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  53  getfield local.ua.UserAgentProfile.redirect_to : org.zoolu.sip.address.NameAddress [203]
//  56  invokevirtual local.ua.UserAgent.redirect(org.zoolu.sip.address.NameAddress) : void [205]
//  59  goto 146
//  62  aload_0 [this]
//  63  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  66  getfield local.ua.UserAgentProfile.accept_time : int [206]
//  69  iflt 116
//  72  aload_0 [this]
//  73  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  76  ldc <String "ON CALL"> [182]
//  78  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  81  aload_0 [this]
//  82  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
//  85  aconst_null
//  86  invokevirtual javax.swing.JComboBox.setSelectedItem(java.lang.Object) : void [133]
//  89  aload_0 [this]
//  90  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
//  93  aload_3 [arg2]
//  94  invokevirtual org.zoolu.sip.address.NameAddress.toString() : java.lang.String [163]
//  97  invokeinterface javax.swing.ComboBoxEditor.setItem(java.lang.Object) : void [164] [nargs: 2]
// 102  aload_0 [this]
// 103  aload_0 [this]
// 104  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 107  getfield local.ua.UserAgentProfile.accept_time : int [206]
// 110  invokevirtual local.ua.GraphicalUA.automaticAccept(int) : void [207]
// 113  goto 146
// 116  aload_0 [this]
// 117  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
// 120  ldc <String "INCOMING CALL"> [208]
// 122  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 125  aload_0 [this]
// 126  getfield local.ua.GraphicalUA.jComboBox1 : javax.swing.JComboBox [24]
// 129  aconst_null
// 130  invokevirtual javax.swing.JComboBox.setSelectedItem(java.lang.Object) : void [133]
// 133  aload_0 [this]
// 134  getfield local.ua.GraphicalUA.comboBoxEditor1 : javax.swing.ComboBoxEditor [40]
// 137  aload_3 [arg2]
// 138  invokevirtual org.zoolu.sip.address.NameAddress.toString() : java.lang.String [163]
// 141  invokeinterface javax.swing.ComboBoxEditor.setItem(java.lang.Object) : void [164] [nargs: 2]
// 146  return
//   Line numbers:
//     [pc: 0, line: 409]
//     [pc: 6, line: 410]
//     [pc: 16, line: 411]
//     [pc: 48, line: 412]
//     [pc: 62, line: 415]
//     [pc: 72, line: 416]
//     [pc: 81, line: 417]
//     [pc: 89, line: 418]
//     [pc: 102, line: 420]
//     [pc: 116, line: 423]
//     [pc: 125, line: 424]
//     [pc: 133, line: 425]
//     [pc: 146, line: 427]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallProgress(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "PROGRESS"> [209]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  return
//   Line numbers:
//     [pc: 0, line: 432]
//     [pc: 9, line: 433]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallRinging(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "RINGING"> [210]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  return
//   Line numbers:
//     [pc: 0, line: 438]
//     [pc: 9, line: 439]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallAccepted(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "ON CALL"> [182]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  aload_0 [this]
// 10  ldc <String "ONCALL"> [183]
// 12  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 15  aload_0 [this]
// 16  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 19  getfield local.ua.UserAgentProfile.hangup_time : int [178]
// 22  ifle 36
// 25  aload_0 [this]
// 26  aload_0 [this]
// 27  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
// 30  getfield local.ua.UserAgentProfile.hangup_time : int [178]
// 33  invokevirtual local.ua.GraphicalUA.automaticHangup(int) : void [179]
// 36  return
//   Line numbers:
//     [pc: 0, line: 444]
//     [pc: 9, line: 445]
//     [pc: 15, line: 446]
//     [pc: 36, line: 447]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallCancelled(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "CANCELLED"> [211]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  aload_0 [this]
// 10  ldc <String "IDLE"> [45]
// 12  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 15  return
//   Line numbers:
//     [pc: 0, line: 452]
//     [pc: 9, line: 454]
//     [pc: 15, line: 455]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallTransferred(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "TRASFERRED"> [212]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  aload_0 [this]
// 10  ldc <String "IDLE"> [45]
// 12  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 15  return
//   Line numbers:
//     [pc: 0, line: 460]
//     [pc: 9, line: 462]
//     [pc: 15, line: 463]
//
//// Method descriptor #335 (Llocal/ua/UserAgent;Ljava/lang/String;)V
//// Stack: 4, Locals: 3
//public void onUaCallFailed(local.ua.UserAgent arg0, java.lang.String arg1);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  new java.lang.StringBuffer [2]
//  7  dup
//  8  invokespecial java.lang.StringBuffer() [3]
// 11  ldc <String "FAILED"> [213]
// 13  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 16  aload_2 [arg1]
// 17  ifnull 47
// 20  new java.lang.StringBuffer [2]
// 23  dup
// 24  invokespecial java.lang.StringBuffer() [3]
// 27  ldc <String " ("> [214]
// 29  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 32  aload_2 [arg1]
// 33  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 36  ldc <String ")"> [215]
// 38  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 41  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 44  goto 49
// 47  ldc <String ""> [216]
// 49  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 52  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 55  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
// 58  aload_0 [this]
// 59  ldc <String "IDLE"> [45]
// 61  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 64  return
//   Line numbers:
//     [pc: 0, line: 468]
//     [pc: 58, line: 470]
//     [pc: 64, line: 471]
//
//// Method descriptor #329 (Llocal/ua/UserAgent;)V
//// Stack: 2, Locals: 2
//public void onUaCallClosed(local.ua.UserAgent arg0);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.display : javax.swing.JTextField [44]
//  4  ldc <String "BYE"> [217]
//  6  invokevirtual javax.swing.JTextField.setText(java.lang.String) : void [100]
//  9  aload_0 [this]
// 10  ldc <String "IDLE"> [45]
// 12  invokevirtual local.ua.GraphicalUA.changeStatus(java.lang.String) : void [53]
// 15  return
//   Line numbers:
//     [pc: 0, line: 476]
//     [pc: 9, line: 478]
//     [pc: 15, line: 479]
//
//// Method descriptor #338 (Llocal/ua/UserAgent;Ljava/lang/String;Ljava/lang/String;)V
//// Stack: 0, Locals: 4
//public void onUaMediaSessionStarted(local.ua.UserAgent arg0, java.lang.String arg1, java.lang.String arg2);
// 0  return
//   Line numbers:
//     [pc: 0, line: 484]
//
//// Method descriptor #335 (Llocal/ua/UserAgent;Ljava/lang/String;)V
//// Stack: 0, Locals: 3
//public void onUaMediaSessionStopped(local.ua.UserAgent arg0, java.lang.String arg1);
// 0  return
//   Line numbers:
//     [pc: 0, line: 489]
//
//// Method descriptor #335 (Llocal/ua/UserAgent;Ljava/lang/String;)V
//// Stack: 3, Locals: 3
//public void onUaRegistrationSucceeded(local.ua.UserAgent arg0, java.lang.String arg1);
//  0  aload_0 [this]
//  1  aload_0 [this]
//  2  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  5  invokevirtual local.ua.UserAgentProfile.getUserURI() : org.zoolu.sip.address.NameAddress [218]
//  8  invokevirtual org.zoolu.sip.address.NameAddress.toString() : java.lang.String [163]
// 11  invokevirtual local.ua.GraphicalUA.setTitle(java.lang.String) : void [90]
// 14  aload_0 [this]
// 15  new java.lang.StringBuffer [2]
// 18  dup
// 19  invokespecial java.lang.StringBuffer() [3]
// 22  ldc <String "REGISTRATION SUCCESS: "> [219]
// 24  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 27  aload_2 [arg1]
// 28  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 31  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 34  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 37  return
//   Line numbers:
//     [pc: 0, line: 494]
//     [pc: 14, line: 495]
//     [pc: 37, line: 496]
//
//// Method descriptor #335 (Llocal/ua/UserAgent;Ljava/lang/String;)V
//// Stack: 3, Locals: 3
//public void onUaRegistrationFailed(local.ua.UserAgent arg0, java.lang.String arg1);
//  0  aload_0 [this]
//  1  aload_0 [this]
//  2  getfield local.ua.GraphicalUA.sip_provider : org.zoolu.sip.provider.SipProvider [46]
//  5  aload_0 [this]
//  6  getfield local.ua.GraphicalUA.ua_profile : local.ua.UserAgentProfile [47]
//  9  getfield local.ua.UserAgentProfile.user : java.lang.String [87]
// 12  invokevirtual org.zoolu.sip.provider.SipProvider.getContactAddress(java.lang.String) : org.zoolu.sip.address.SipURL [88]
// 15  invokevirtual org.zoolu.sip.address.SipURL.toString() : java.lang.String [89]
// 18  invokevirtual local.ua.GraphicalUA.setTitle(java.lang.String) : void [90]
// 21  aload_0 [this]
// 22  new java.lang.StringBuffer [2]
// 25  dup
// 26  invokespecial java.lang.StringBuffer() [3]
// 29  ldc <String "REGISTRATION FAILURE: "> [221]
// 31  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 34  aload_2 [arg1]
// 35  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 38  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 41  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 44  return
//   Line numbers:
//     [pc: 0, line: 500]
//     [pc: 21, line: 501]
//     [pc: 44, line: 502]
//
//// Method descriptor #343 (I)V
//// Stack: 5, Locals: 2
//void reInvite(int arg0);
//  0  aload_0 [this]
//  1  new java.lang.StringBuffer [2]
//  4  dup
//  5  invokespecial java.lang.StringBuffer() [3]
//  8  ldc <String "AUTOMATIC RE-INVITING/MODIFING: "> [222]
// 10  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 13  iload_1 [arg0]
// 14  invokevirtual java.lang.StringBuffer.append(int) : java.lang.StringBuffer [223]
// 17  ldc <String " secs"> [224]
// 19  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 22  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 25  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 28  iload_1 [arg0]
// 29  ifne 43
// 32  aload_0 [this]
// 33  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 36  aconst_null
// 37  invokevirtual local.ua.UserAgent.modify(java.lang.String) : void [225]
// 40  goto 57
// 43  new local.ua.GraphicalUA$8 [226]
// 46  dup
// 47  aload_0 [this]
// 48  iload_1 [arg0]
// 49  sipush 1000
// 52  imul
// 53  invokespecial local.ua.GraphicalUA$8(local.ua.GraphicalUA, int) [227]
// 56  pop
// 57  return
//   Line numbers:
//     [pc: 0, line: 518]
//     [pc: 28, line: 519]
//     [pc: 43, line: 520]
//     [pc: 57, line: 521]
//
//// Method descriptor #345 (Lorg/zoolu/sip/address/NameAddress;I)V
//// Stack: 5, Locals: 3
//void callTransfer(org.zoolu.sip.address.NameAddress arg0, int arg1);
//  0  aload_0 [this]
//  1  new java.lang.StringBuffer [2]
//  4  dup
//  5  invokespecial java.lang.StringBuffer() [3]
//  8  ldc <String "AUTOMATIC REFER/TRANSFER: "> [228]
// 10  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 13  iload_2 [arg1]
// 14  invokevirtual java.lang.StringBuffer.append(int) : java.lang.StringBuffer [223]
// 17  ldc <String " secs"> [224]
// 19  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 22  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 25  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 28  iload_2 [arg1]
// 29  ifne 43
// 32  aload_0 [this]
// 33  getfield local.ua.GraphicalUA.ua : local.ua.UserAgent [52]
// 36  aload_1 [arg0]
// 37  invokevirtual local.ua.UserAgent.transfer(org.zoolu.sip.address.NameAddress) : void [229]
// 40  goto 58
// 43  new local.ua.GraphicalUA$9 [230]
// 46  dup
// 47  aload_0 [this]
// 48  iload_2 [arg1]
// 49  sipush 1000
// 52  imul
// 53  aload_1 [arg0]
// 54  invokespecial local.ua.GraphicalUA$9(local.ua.GraphicalUA, int, org.zoolu.sip.address.NameAddress) [231]
// 57  pop
// 58  return
//   Line numbers:
//     [pc: 0, line: 535]
//     [pc: 28, line: 536]
//     [pc: 43, line: 537]
//     [pc: 58, line: 538]
//
//// Method descriptor #343 (I)V
//// Stack: 5, Locals: 2
//void automaticAccept(int arg0);
//  0  aload_0 [this]
//  1  new java.lang.StringBuffer [2]
//  4  dup
//  5  invokespecial java.lang.StringBuffer() [3]
//  8  ldc <String "AUTOMATIC ANSWER: "> [232]
// 10  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 13  iload_1 [arg0]
// 14  invokevirtual java.lang.StringBuffer.append(int) : java.lang.StringBuffer [223]
// 17  ldc <String " secs"> [224]
// 19  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 22  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 25  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 28  iload_1 [arg0]
// 29  ifne 39
// 32  aload_0 [this]
// 33  invokevirtual local.ua.GraphicalUA.jButton1_actionPerformed() : void [233]
// 36  goto 53
// 39  new local.ua.GraphicalUA$10 [234]
// 42  dup
// 43  aload_0 [this]
// 44  iload_1 [arg0]
// 45  sipush 1000
// 48  imul
// 49  invokespecial local.ua.GraphicalUA$10(local.ua.GraphicalUA, int) [235]
// 52  pop
// 53  return
//   Line numbers:
//     [pc: 0, line: 552]
//     [pc: 28, line: 553]
//     [pc: 39, line: 554]
//     [pc: 53, line: 555]
//
//// Method descriptor #343 (I)V
//// Stack: 5, Locals: 2
//void automaticHangup(int arg0);
//  0  aload_0 [this]
//  1  new java.lang.StringBuffer [2]
//  4  dup
//  5  invokespecial java.lang.StringBuffer() [3]
//  8  ldc <String "AUTOMATIC HANGUP: "> [236]
// 10  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 13  iload_1 [arg0]
// 14  invokevirtual java.lang.StringBuffer.append(int) : java.lang.StringBuffer [223]
// 17  ldc <String " secs"> [224]
// 19  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 22  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 25  invokespecial local.ua.GraphicalUA.printLog(java.lang.String) : void [220]
// 28  iload_1 [arg0]
// 29  ifne 39
// 32  aload_0 [this]
// 33  invokevirtual local.ua.GraphicalUA.jButton2_actionPerformed() : void [171]
// 36  goto 53
// 39  new local.ua.GraphicalUA$11 [237]
// 42  dup
// 43  aload_0 [this]
// 44  iload_1 [arg0]
// 45  sipush 1000
// 48  imul
// 49  invokespecial local.ua.GraphicalUA$11(local.ua.GraphicalUA, int) [238]
// 52  pop
// 53  return
//   Line numbers:
//     [pc: 0, line: 569]
//     [pc: 28, line: 570]
//     [pc: 39, line: 571]
//     [pc: 53, line: 572]
//
//// Method descriptor #349 ([Ljava/lang/String;)V
//// Stack: 4, Locals: 1
//public static void main(java.lang.String[] arg0);
//  0  getstatic java.lang.System.out : java.io.PrintStream [193]
//  3  ldc <String "MJSIP UA 1.7"> [239]
//  5  invokevirtual java.io.PrintStream.println(java.lang.String) : void [195]
//  8  ldc <String "local.ua.GraphicalUA"> [240]
// 10  aload_0 [arg0]
// 11  invokestatic local.ua.UA.init(java.lang.String, java.lang.String[]) : boolean [241]
// 14  ifne 21
// 17  iconst_0
// 18  invokestatic java.lang.System.exit(int) : void [172]
// 21  new local.ua.GraphicalUA [242]
// 24  dup
// 25  getstatic local.ua.UA.sip_provider : org.zoolu.sip.provider.SipProvider [243]
// 28  getstatic local.ua.UA.ua_profile : local.ua.UserAgentProfile [244]
// 31  invokespecial local.ua.GraphicalUA(org.zoolu.sip.provider.SipProvider, local.ua.UserAgentProfile) [245]
// 34  pop
// 35  return
//   Line numbers:
//     [pc: 0, line: 580]
//     [pc: 8, line: 582]
//     [pc: 21, line: 584]
//     [pc: 35, line: 585]
//
//// Method descriptor #307 (Ljava/lang/String;)V
//// Stack: 3, Locals: 2
//private void printLog(java.lang.String arg0);
// 0  aload_0 [this]
// 1  aload_1 [arg0]
// 2  iconst_1
// 3  invokespecial local.ua.GraphicalUA.printLog(java.lang.String, int) : void [7]
// 6  return
//   Line numbers:
//     [pc: 0, line: 592]
//     [pc: 6, line: 593]
//
//// Method descriptor #351 (Ljava/lang/String;I)V
//// Stack: 4, Locals: 3
//private void printLog(java.lang.String arg0, int arg1);
//  0  aload_0 [this]
//  1  getfield local.ua.GraphicalUA.log : org.zoolu.tools.Log [49]
//  4  ifnull 37
//  7  aload_0 [this]
//  8  getfield local.ua.GraphicalUA.log : org.zoolu.tools.Log [49]
// 11  new java.lang.StringBuffer [2]
// 14  dup
// 15  invokespecial java.lang.StringBuffer() [3]
// 18  ldc <String "GraphicalUA: "> [246]
// 20  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 23  aload_1 [arg0]
// 24  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 27  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 30  iconst_0
// 31  iload_2 [arg1]
// 32  iadd
// 33  invokevirtual org.zoolu.tools.Log.println(java.lang.String, int) : org.zoolu.tools.Log [247]
// 36  pop
// 37  return
//   Line numbers:
//     [pc: 0, line: 597]
//     [pc: 37, line: 598]
//
//// Method descriptor #353 (Ljava/lang/Exception;I)V
//// Stack: 3, Locals: 3
//private void printException(java.lang.Exception arg0, int arg1);
//  0  aload_0 [this]
//  1  new java.lang.StringBuffer [2]
//  4  dup
//  5  invokespecial java.lang.StringBuffer() [3]
//  8  ldc <String "Exception: "> [248]
// 10  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 13  aload_1 [arg0]
// 14  invokestatic org.zoolu.tools.ExceptionPrinter.getStackTraceOf(java.lang.Exception) : java.lang.String [249]
// 17  invokevirtual java.lang.StringBuffer.append(java.lang.String) : java.lang.StringBuffer [5]
// 20  invokevirtual java.lang.StringBuffer.toString() : java.lang.String [6]
// 23  iload_2 [arg1]
// 24  invokespecial local.ua.GraphicalUA.printLog(java.lang.String, int) : void [7]
// 27  return
//   Line numbers:
//     [pc: 0, line: 602]
//     [pc: 27, line: 603]
//
//Inner classes:
// [inner class info: #91 local/ua/GraphicalUA$1, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #107 local/ua/GraphicalUA$2, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #110 local/ua/GraphicalUA$3, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #114 local/ua/GraphicalUA$4, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #116 local/ua/GraphicalUA$5, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #118 local/ua/GraphicalUA$6, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #121 local/ua/GraphicalUA$7, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #226 local/ua/GraphicalUA$8, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #230 local/ua/GraphicalUA$9, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #234 local/ua/GraphicalUA$10, outer class info: #0
//  inner name: #0, accessflags: 0 default],
// [inner class info: #237 local/ua/GraphicalUA$11, outer class info: #0
//  inner name: #0, accessflags: 0 default]
//}