/*
 * Copyright (c) 2014 Amberfog.
 *
 * This source code is Amberfog Confidential Proprietary
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse
 * engineer the software. Otherwise this violation would be treated by law and
 * would be subject to legal prosecution. Legal use of the software provides
 * receipt of a license from the right holder only.
 */

package com.amberfog.countryflagsdemo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneUtils {

    public static String getCountryRegionFromPhone(Context paramContext) {
        TelephonyManager service = null;
        int res = paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        if (res == PackageManager.PERMISSION_GRANTED) {
            service = (TelephonyManager) paramContext.getSystemService(Context.TELEPHONY_SERVICE);
        }
        String code = null;
        if (service != null) {
            String str = service.getLine1Number();
            if (!TextUtils.isEmpty(str) && !str.matches("^0*$")) {
                code = parseNumber(str);
            }
        }
        if (code == null) {
            if (service != null) {
                code = service.getNetworkCountryIso();
            }
            if (code == null) {
                code = paramContext.getResources().getConfiguration().locale.getCountry();
            }
        }
        if (code != null) {
            return code.toUpperCase();
        }
        return null;
    }

    private static String parseNumber(String paramString) {
        if (paramString == null) {
            return null;
        }
        PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
        String result;
        try {
            Phonenumber.PhoneNumber localPhoneNumber = numberUtil.parse(paramString, null);
            result = numberUtil.getRegionCodeForNumber(localPhoneNumber);
            if (result == null) {
                return null;
            }
        } catch (NumberParseException localNumberParseException) {
            return null;
        }
        return result;
    }


}