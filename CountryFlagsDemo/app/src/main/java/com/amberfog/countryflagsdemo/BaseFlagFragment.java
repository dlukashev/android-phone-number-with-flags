/*
 * Copyright (c) 2014-2015 Amberfog.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amberfog.countryflagsdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public abstract class BaseFlagFragment extends Fragment {

    protected static final TreeSet<String> CANADA_CODES = new TreeSet<String>();
    protected static final TreeSet<String> US_CODES = new TreeSet<String>();
    protected static final TreeSet<String> DO_CODES = new TreeSet<String>();
    protected static final TreeSet<String> PR_CODES = new TreeSet<String>();

    static {
        //USA
        US_CODES.add("201");
        US_CODES.add("202");
        US_CODES.add("203");
        US_CODES.add("205");
        US_CODES.add("206");
        US_CODES.add("207");
        US_CODES.add("208");
        US_CODES.add("209");
        US_CODES.add("210");
        US_CODES.add("212");
        US_CODES.add("213");
        US_CODES.add("214");
        US_CODES.add("215");
        US_CODES.add("216");
        US_CODES.add("217");
        US_CODES.add("218");
        US_CODES.add("219");
        US_CODES.add("224");
        US_CODES.add("225");
        US_CODES.add("228");
        US_CODES.add("229");
        US_CODES.add("231");
        US_CODES.add("234");
        US_CODES.add("239");
        US_CODES.add("240");
        US_CODES.add("248");
        US_CODES.add("251");
        US_CODES.add("252");
        US_CODES.add("253");
        US_CODES.add("254");
        US_CODES.add("256");
        US_CODES.add("260");
        US_CODES.add("262");
        US_CODES.add("267");
        US_CODES.add("269");
        US_CODES.add("270");
        US_CODES.add("276");
        US_CODES.add("281");
        US_CODES.add("301");
        US_CODES.add("302");
        US_CODES.add("303");
        US_CODES.add("304");
        US_CODES.add("305");
        US_CODES.add("307");
        US_CODES.add("308");
        US_CODES.add("309");
        US_CODES.add("310");
        US_CODES.add("312");
        US_CODES.add("313");
        US_CODES.add("314");
        US_CODES.add("315");
        US_CODES.add("316");
        US_CODES.add("317");
        US_CODES.add("318");
        US_CODES.add("319");
        US_CODES.add("320");
        US_CODES.add("321");
        US_CODES.add("323");
        US_CODES.add("325");
        US_CODES.add("330");
        US_CODES.add("334");
        US_CODES.add("336");
        US_CODES.add("337");
        US_CODES.add("339");
        US_CODES.add("347");
        US_CODES.add("351");
        US_CODES.add("352");
        US_CODES.add("360");
        US_CODES.add("361");
        US_CODES.add("386");
        US_CODES.add("401");
        US_CODES.add("402");
        US_CODES.add("404");
        US_CODES.add("405");
        US_CODES.add("406");
        US_CODES.add("407");
        US_CODES.add("408");
        US_CODES.add("409");
        US_CODES.add("410");
        US_CODES.add("412");
        US_CODES.add("413");
        US_CODES.add("414");
        US_CODES.add("415");
        US_CODES.add("417");
        US_CODES.add("419");
        US_CODES.add("423");
        US_CODES.add("425");
        US_CODES.add("430");
        US_CODES.add("432");
        US_CODES.add("434");
        US_CODES.add("435");
        US_CODES.add("440");
        US_CODES.add("443");
        US_CODES.add("469");
        US_CODES.add("478");
        US_CODES.add("479");
        US_CODES.add("480");
        US_CODES.add("484");
        US_CODES.add("501");
        US_CODES.add("502");
        US_CODES.add("503");
        US_CODES.add("504");
        US_CODES.add("505");
        US_CODES.add("507");
        US_CODES.add("508");
        US_CODES.add("509");
        US_CODES.add("510");
        US_CODES.add("512");
        US_CODES.add("513");
        US_CODES.add("515");
        US_CODES.add("516");
        US_CODES.add("517");
        US_CODES.add("518");
        US_CODES.add("520");
        US_CODES.add("530");
        US_CODES.add("540");
        US_CODES.add("541");
        US_CODES.add("551");
        US_CODES.add("559");
        US_CODES.add("561");
        US_CODES.add("562");
        US_CODES.add("563");
        US_CODES.add("567");
        US_CODES.add("570");
        US_CODES.add("571");
        US_CODES.add("573");
        US_CODES.add("574");
        US_CODES.add("575");
        US_CODES.add("580");
        US_CODES.add("585");
        US_CODES.add("586");
        US_CODES.add("601");
        US_CODES.add("602");
        US_CODES.add("603");
        US_CODES.add("605");
        US_CODES.add("606");
        US_CODES.add("607");
        US_CODES.add("608");
        US_CODES.add("609");
        US_CODES.add("610");
        US_CODES.add("612");
        US_CODES.add("614");
        US_CODES.add("615");
        US_CODES.add("616");
        US_CODES.add("617");
        US_CODES.add("618");
        US_CODES.add("619");
        US_CODES.add("620");
        US_CODES.add("623");
        US_CODES.add("626");
        US_CODES.add("630");
        US_CODES.add("631");
        US_CODES.add("636");
        US_CODES.add("641");
        US_CODES.add("646");
        US_CODES.add("650");
        US_CODES.add("651");
        US_CODES.add("660");
        US_CODES.add("661");
        US_CODES.add("662");
        US_CODES.add("678");
        US_CODES.add("682");
        US_CODES.add("701");
        US_CODES.add("702");
        US_CODES.add("703");
        US_CODES.add("704");
        US_CODES.add("706");
        US_CODES.add("707");
        US_CODES.add("708");
        US_CODES.add("712");
        US_CODES.add("713");
        US_CODES.add("714");
        US_CODES.add("715");
        US_CODES.add("716");
        US_CODES.add("717");
        US_CODES.add("718");
        US_CODES.add("719");
        US_CODES.add("720");
        US_CODES.add("724");
        US_CODES.add("727");
        US_CODES.add("731");
        US_CODES.add("732");
        US_CODES.add("734");
        US_CODES.add("740");
        US_CODES.add("754");
        US_CODES.add("757");
        US_CODES.add("760");
        US_CODES.add("763");
        US_CODES.add("765");
        US_CODES.add("770");
        US_CODES.add("772");
        US_CODES.add("773");
        US_CODES.add("774");
        US_CODES.add("775");
        US_CODES.add("781");
        US_CODES.add("785");
        US_CODES.add("786");
        US_CODES.add("801");
        US_CODES.add("802");
        US_CODES.add("803");
        US_CODES.add("804");
        US_CODES.add("805");
        US_CODES.add("806");
        US_CODES.add("808");
        US_CODES.add("810");
        US_CODES.add("812");
        US_CODES.add("813");
        US_CODES.add("814");
        US_CODES.add("815");
        US_CODES.add("816");
        US_CODES.add("817");
        US_CODES.add("818");
        US_CODES.add("828");
        US_CODES.add("830");
        US_CODES.add("831");
        US_CODES.add("832");
        US_CODES.add("843");
        US_CODES.add("845");
        US_CODES.add("847");
        US_CODES.add("848");
        US_CODES.add("850");
        US_CODES.add("856");
        US_CODES.add("857");
        US_CODES.add("858");
        US_CODES.add("859");
        US_CODES.add("860");
        US_CODES.add("862");
        US_CODES.add("863");
        US_CODES.add("864");
        US_CODES.add("865");
        US_CODES.add("866");
        US_CODES.add("870");
        US_CODES.add("901");
        US_CODES.add("903");
        US_CODES.add("904");
        US_CODES.add("906");
        US_CODES.add("907");
        US_CODES.add("908");
        US_CODES.add("909");
        US_CODES.add("910");
        US_CODES.add("912");
        US_CODES.add("913");
        US_CODES.add("914");
        US_CODES.add("915");
        US_CODES.add("916");
        US_CODES.add("917");
        US_CODES.add("918");
        US_CODES.add("919");
        US_CODES.add("920");
        US_CODES.add("925");
        US_CODES.add("928");
        US_CODES.add("931");
        US_CODES.add("936");
        US_CODES.add("937");
        US_CODES.add("940");
        US_CODES.add("941");
        US_CODES.add("947");
        US_CODES.add("949");
        US_CODES.add("951");
        US_CODES.add("952");
        US_CODES.add("954");
        US_CODES.add("956");
        US_CODES.add("970");
        US_CODES.add("971");
        US_CODES.add("972");
        US_CODES.add("973");
        US_CODES.add("978");
        US_CODES.add("979");
        US_CODES.add("980");
        US_CODES.add("985");
        US_CODES.add("989");

        //Dominican Republic
        DO_CODES.add("809");
        DO_CODES.add("829");
        DO_CODES.add("849");

        //Puerto Rico
        PR_CODES.add("787");
        PR_CODES.add("939");

        //Canada
        CANADA_CODES.add("204");
        CANADA_CODES.add("226");
        CANADA_CODES.add("236");
        CANADA_CODES.add("249");
        CANADA_CODES.add("250");
        CANADA_CODES.add("289");
        CANADA_CODES.add("306");
        CANADA_CODES.add("343");
        CANADA_CODES.add("365");
        CANADA_CODES.add("387");
        CANADA_CODES.add("403");
        CANADA_CODES.add("416");
        CANADA_CODES.add("418");
        CANADA_CODES.add("431");
        CANADA_CODES.add("437");
        CANADA_CODES.add("438");
        CANADA_CODES.add("450");
        CANADA_CODES.add("506");
        CANADA_CODES.add("514");
        CANADA_CODES.add("519");
        CANADA_CODES.add("548");
        CANADA_CODES.add("579");
        CANADA_CODES.add("581");
        CANADA_CODES.add("587");
        CANADA_CODES.add("604");
        CANADA_CODES.add("613");
        CANADA_CODES.add("639");
        CANADA_CODES.add("647");
        CANADA_CODES.add("672");
        CANADA_CODES.add("705");
        CANADA_CODES.add("709");
        CANADA_CODES.add("742");
        CANADA_CODES.add("778");
        CANADA_CODES.add("780");
        CANADA_CODES.add("782");
        CANADA_CODES.add("807");
        CANADA_CODES.add("819");
        CANADA_CODES.add("825");
        CANADA_CODES.add("867");
        CANADA_CODES.add("873");
        CANADA_CODES.add("902");
        CANADA_CODES.add("905");
    }

    protected SparseArray<ArrayList<Country>> mCountriesMap = new SparseArray<ArrayList<Country>>();

    protected PhoneNumberUtil mPhoneNumberUtil = PhoneNumberUtil.getInstance();
    protected Spinner mSpinner;

    protected String mLastEnteredPhone;
    protected EditText mPhoneEdit;
    protected CountryAdapter mAdapter;

    protected TextView mBtnLink;

    protected AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Country c = (Country) mSpinner.getItemAtPosition(position);
            if (mLastEnteredPhone != null && mLastEnteredPhone.startsWith(c.getCountryCodeStr())) {
                return;
            }
            mPhoneEdit.getText().clear();
            mPhoneEdit.getText().insert(mPhoneEdit.getText().length() > 0 ? 1 : 0, String.valueOf(c.getCountryCode()));
            mPhoneEdit.setSelection(mPhoneEdit.length());
            mLastEnteredPhone = null;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    protected OnPhoneChangedListener mOnPhoneChangedListener = new OnPhoneChangedListener() {
        @Override
        public void onPhoneChanged(String phone) {
            try {
                mLastEnteredPhone = phone;
                Phonenumber.PhoneNumber p = mPhoneNumberUtil.parse(phone, null);
                ArrayList<Country> list = mCountriesMap.get(p.getCountryCode());
                Country country = null;
                if (list != null) {
                    if (p.getCountryCode() == 1) {
                        String num = String.valueOf(p.getNationalNumber());
                        if (num.length() >= 3) {
                            String code = num.substring(0, 3);
                            if (CANADA_CODES.contains(code)) {
                                for (Country c : list) {
                                    // Canada has priority 2, US has priority 1
                                    if (c.getPriority() == 2) {
                                        country = c;
                                        break;
                                    }
                                }
                            }
                            else if (DO_CODES.contains(code)) {
                                for (Country c : list) {
                                    // Dominican Republic has priority 3
                                    if (c.getPriority() == 3) {
                                        country = c;
                                        break;
                                    }
                                }
                            }
                            else if (PR_CODES.contains(code)) {
                                for (Country c : list) {
                                    // Puerto Rico has priority 4
                                    if (c.getPriority() == 4) {
                                        country = c;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (country == null) {
                        //If no country code is entered, default to US
                        for (Country c : list) {
                            if (c.getPriority() == 1) {
                                country = c;
                                break;
                            }
                        }
                    }
                }
                if (country != null) {
                    final int position = country.getNum();
                    mSpinner.post(new Runnable() {
                        @Override
                        public void run() {
                            mSpinner.setSelection(position);
                        }
                    });
                }
            } catch (NumberParseException ignore) {
            }

        }
    };

    protected void initUI(View rootView) {
        mSpinner = (Spinner) rootView.findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(mOnItemSelectedListener);

        mAdapter = new CountryAdapter(getActivity());

        mSpinner.setAdapter(mAdapter);

        mPhoneEdit = (EditText) rootView.findViewById(R.id.phone);
        mPhoneEdit.addTextChangedListener(new CustomPhoneNumberFormattingTextWatcher(mOnPhoneChangedListener));
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    if (dstart > 0 && !Character.isDigit(c)) {
                        return "";
                    }
                }
                return null;
            }
        };

        mPhoneEdit.setFilters(new InputFilter[]{filter});

        mBtnLink = (TextView) rootView.findViewById(R.id.btn_send);
        mBtnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        mPhoneEdit.setImeOptions(EditorInfo.IME_ACTION_SEND);
        mPhoneEdit.setImeActionLabel(getString(R.string.label_send), EditorInfo.IME_ACTION_SEND);
        mPhoneEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    send();
                    return true;
                }
                return false;
            }
        });

    }

    protected void initCodes(Context context) {
        new AsyncPhoneInitTask(context).execute();
    }

    protected class AsyncPhoneInitTask extends AsyncTask<Void, Void, ArrayList<Country>> {

        private int mSpinnerPosition = -1;
        private Context mContext;

        public AsyncPhoneInitTask(Context context) {
            mContext = context;
        }

        @Override
        protected ArrayList<Country> doInBackground(Void... params) {
            ArrayList<Country> data = new ArrayList<Country>(233);
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(mContext.getApplicationContext().getAssets().open("countries.dat"), "UTF-8"));

                // do reading, usually loop until end of file reading
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    //process line
                    Country c = new Country(mContext, line, i);
                    data.add(c);
                    ArrayList<Country> list = mCountriesMap.get(c.getCountryCode());
                    if (list == null) {
                        list = new ArrayList<Country>();
                        mCountriesMap.put(c.getCountryCode(), list);
                    }
                    list.add(c);
                    i++;
                }
            } catch (IOException e) {
                //log the exception
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        //log the exception
                    }
                }
            }
            String countryRegion = PhoneUtils.getCountryRegionFromPhone(mContext);
            int code = mPhoneNumberUtil.getCountryCodeForRegion(countryRegion);
            ArrayList<Country> list = mCountriesMap.get(code);
            if (list != null) {
                for (Country c : list) {
                    if (c.getPriority() == 0 || c.getPriority() == 1) {
                        mSpinnerPosition = c.getNum();
                        break;
                    }
                }
            }
            return data;
        }

        @Override
        protected void onPostExecute(ArrayList<Country> data) {
            mAdapter.addAll(data);
            if (mSpinnerPosition > 0) {
                mSpinner.setSelection(mSpinnerPosition);
            }
        }
    }

    protected abstract void send();

    protected String validate() {
        String region = null;
        String phone = null;
        if (mLastEnteredPhone != null) {
            try {
                Phonenumber.PhoneNumber p = mPhoneNumberUtil.parse(mLastEnteredPhone, null);
                StringBuilder sb = new StringBuilder(16);
                sb.append('+').append(p.getCountryCode()).append(p.getNationalNumber());
                phone = sb.toString();
                region = mPhoneNumberUtil.getRegionCodeForNumber(p);
            } catch (NumberParseException ignore) {
            }
        }
        if (region != null) {
            return phone;
        } else {
            return null;
        }
    }

    protected void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    protected void showKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

}
