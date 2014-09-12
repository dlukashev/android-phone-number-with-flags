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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class VerifyPhoneFragment extends BaseFlagFragment {

    public VerifyPhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flags, container, false);
        initUI(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initCodes(getActivity());
    }

    @Override
    protected void send() {
        hideKeyboard(mPhoneEdit);
        mPhoneEdit.setError(null);
        String phone = validate();
        if (phone == null) {
            mPhoneEdit.requestFocus();
            mPhoneEdit.setError(getString(R.string.label_error_incorrect_phone));
            return;
        }
        Toast.makeText(getActivity(), "send to " + phone, Toast.LENGTH_SHORT).show();
    }
}
