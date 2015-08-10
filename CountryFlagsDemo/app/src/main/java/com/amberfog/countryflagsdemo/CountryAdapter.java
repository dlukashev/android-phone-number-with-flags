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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends ArrayAdapter<Country> {

    private LayoutInflater mLayoutInflater;

    public CountryAdapter(Context context) {
        super(context, 0);
        mLayoutInflater = LayoutInflater.from(context);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_country_drop, parent, false);
            holder = new ViewHolder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.image);
            holder.mNameView = (TextView) convertView.findViewById(R.id.country_name);
            holder.mCodeView = (TextView) convertView.findViewById(R.id.country_code);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Country country = getItem(position);
        if (country != null) {
            holder.mNameView.setText(country.getName());
            holder.mCodeView.setText(country.getCountryCodeStr());
            holder.mImageView.setImageResource(country.getResId());
        }
        return convertView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_country, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(country.getResId());
        return convertView;
    }

    private static class ViewHolder {
        public ImageView mImageView;
        public TextView mNameView;
        public TextView mCodeView;
    }
}
