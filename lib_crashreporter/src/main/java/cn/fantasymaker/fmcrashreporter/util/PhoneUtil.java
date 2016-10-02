/*
 *     Copyright © 2016 Fantasymaker
 *
 *     Permission is hereby granted, free of charge, to any person obtaining a copy
 *     of this software and associated documentation files (the "Software"), to deal
 *     in the Software without restriction, including without limitation the rights
 *     to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *     copies of the Software, and to permit persons to whom the Software is
 *     furnished to do so, subject to the following conditions:
 *
 *     The above copyright notice and this permission notice shall be included in all
 *     copies or substantial portions of the Software.
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *     SOFTWARE.
 */

package cn.fantasymaker.fmcrashreporter.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;

import java.util.List;

import cn.fantasymaker.fmcrashreporter.FMCrashReporter;

/**
 * Created :  2016-10-02
 * Author  :  Fantasymaker
 * Web     :  http://blog.fantasymaker.cn
 * Email   :  me@fantasymaker.cn
 */
public class PhoneUtil {

    /*
    todo 规范方法说明
     */

    /*
    NEED PERMISSIONS:
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
     */

    private static Context sContext = FMCrashReporter.getContext();
    private static TelephonyManager sTelephonyManager = (TelephonyManager) sContext.getSystemService(Context.TELEPHONY_SERVICE);
    private static PackageManager sPackageManager = sContext.getPackageManager();


    /*
     * 电话状态：
     * 1.sTelephonyManager.CALL_STATE_IDLE=0          无活动
     * 2.sTelephonyManager.CALL_STATE_RINGING=1  响铃
     * 3.sTelephonyManager.CALL_STATE_OFFHOOK=2  摘机
     */
    public static int getCallState() {
        return sTelephonyManager.getCallState();
    }

    /*
     * 电话方位：
     *
     */
    public static CellLocation getLocation() {
        return sTelephonyManager.getCellLocation();
    }

    /*
     * 唯一的设备ID：
     * GSM手机的 IMEI 和 CDMA手机的 MEID.
     * Return null if device ID is not available.
     */
    public static String getDeviceIdIMEI() {
        return sTelephonyManager.getDeviceId();
    }

    /*
     * 设备的软件版本号：
     * 例如：the IMEI/SV(software version) for GSM phones.
     * Return null if the software version is not available.
     */
    public static String getDeviceSoftwareVersion() {
        return sTelephonyManager.getDeviceSoftwareVersion();
    }

    /*
     * 手机号：
     * GSM手机的 MSISDN.
     * Return null if it is unavailable.
     */
    public static String getPhone1Number() {
        return sTelephonyManager.getLine1Number();
    }

    /*
     * 附近的电话的信息:
     * 类型：List<NeighboringCellInfo>
     * 需要权限：android.Manifest.permission#ACCESS_COARSE_UPDATES
     */
    public static List<NeighboringCellInfo> getNeighboringCellInfo() {
        return sTelephonyManager.getNeighboringCellInfo();
    }

    /*
     * 获取ISO标准的国家码，即国际长途区号。
     * 注意：仅当用户已在网络注册后有效。
     *       在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkCountryIso() {
        return sTelephonyManager.getNetworkCountryIso();
    }

    /*
     * MCC+MNC(mobile country code + mobile network code)
     * 注意：仅当用户已在网络注册时有效。
     *    在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkOperator() {
        return sTelephonyManager.getNetworkOperator();
    }

    /*
     * 按照字母次序的current registered operator(当前已注册的用户)的名字
     * 注意：仅当用户已在网络注册时有效。
     *    在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkOperatorName() {
        return sTelephonyManager.getNetworkOperatorName();
    }

    /*
     * 当前使用的网络类型：
     * 例如： NETWORK_TYPE_UNKNOWN  网络类型未知  0
       NETWORK_TYPE_GPRS     GPRS网络  1
       NETWORK_TYPE_EDGE     EDGE网络  2
       NETWORK_TYPE_UMTS     UMTS网络  3
       NETWORK_TYPE_HSDPA    HSDPA网络  8
       NETWORK_TYPE_HSUPA    HSUPA网络  9
       NETWORK_TYPE_HSPA     HSPA网络  10
       NETWORK_TYPE_CDMA     CDMA网络,IS95A 或 IS95B.  4
       NETWORK_TYPE_EVDO_0   EVDO网络, revision 0.  5
       NETWORK_TYPE_EVDO_A   EVDO网络, revision A.  6
       NETWORK_TYPE_1xRTT    1xRTT网络  7
     */
    public static int getNetworkType() {
        return sTelephonyManager.getNetworkType();
    }

    public static String getNetworkTypeName() {
        String name = "UNKNOWN";
        switch (getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                name = "1xRTT";
                break;
            case TelephonyManager.NETWORK_TYPE_CDMA:
                name = "CDMA";
                break;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                name = "EDGE";
                break;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                name = "EHRPD";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                name = "EVDO_0";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                name = "EVDO_A";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                name = "EVDO_B";
                break;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                name = "GPRS";
                break;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                name = "HSDPA";
                break;
            case TelephonyManager.NETWORK_TYPE_HSPA:
                name = "HSPA";
                break;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                name = "HSPAP";
                break;
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                name = "HSUPA";
                break;
            case TelephonyManager.NETWORK_TYPE_IDEN:
                name = "IDEN";
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                name = "LTE";
                break;
            case TelephonyManager.NETWORK_TYPE_UMTS:
                name = "UMTS";
                break;
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                name = "UNKNOWN";
                break;
        }
        return name;
    }

    /*
     * 手机类型：
     * 例如： PHONE_TYPE_NONE  无信号
       PHONE_TYPE_GSM   GSM信号
       PHONE_TYPE_CDMA  CDMA信号
     */
    public static int getPhoneType() {
        return sTelephonyManager.getPhoneType();
    }

    /*
     * Returns the ISO country code equivalent for the SIM provider's country code.
     * 获取ISO国家码，相当于提供SIM卡的国家码。
     *
     */
    public static String getSimCountryIso() {
        return sTelephonyManager.getSimCountryIso();
    }

    /*
     * Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM. 5 or 6 decimal digits.
     * 获取SIM卡提供的移动国家码和移动网络码.5或6位的十进制数字.
     * SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断).
     */
    public static String getSimOperator() {
        return sTelephonyManager.getSimOperator();
    }

    /*
     * 服务商名称：
     * 例如：中国移动、联通
     * SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断).
     */
    public static String getSimOperatorName() {
        return sTelephonyManager.getSimOperatorName();
    }

    /*
     * SIM卡的序列号：
     * 需要权限：READ_PHONE_STATE
     */
    public static String getSimSerialNumber() {
        return sTelephonyManager.getSimSerialNumber();
    }

    /*
     * SIM的状态信息：
     *  SIM_STATE_UNKNOWN          未知状态 0
     SIM_STATE_ABSENT           没插卡 1
     SIM_STATE_PIN_REQUIRED     锁定状态，需要用户的PIN码解锁 2
     SIM_STATE_PUK_REQUIRED     锁定状态，需要用户的PUK码解锁 3
     SIM_STATE_NETWORK_LOCKED   锁定状态，需要网络的PIN码解锁 4
     SIM_STATE_READY            就绪状态 5
     */
    public static int getSimState() {
        return sTelephonyManager.getSimState();
    }

    /*
     * 唯一的用户ID：
     * 例如：IMSI(国际移动用户识别码) for a GSM phone.
     * 需要权限：READ_PHONE_STATE
     */
    public static String getSubscriberId() {
        return sTelephonyManager.getSubscriberId();
    }

    /*
     * 取得和语音邮件相关的标签，即为识别符
     * 需要权限：READ_PHONE_STATE
     */
    public static String getVoiceMainAlphaTag() {
        return sTelephonyManager.getVoiceMailAlphaTag();
    }

    /*
     * 获取语音邮件号码：
     * 需要权限：READ_PHONE_STATE
     */
    public static String getVoiceMailNumber() {
        return sTelephonyManager.getVoiceMailNumber();
    }

    /*
     * ICC卡是否存在
     */
    public static boolean hasIccCard() {
        return sTelephonyManager.hasIccCard();
    }

    /*
     * 是否漫游:
     * (在GSM用途下)
     */
    public static boolean isNetworkRoaming() {
        return sTelephonyManager.isNetworkRoaming();
    }
}
