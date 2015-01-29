/* 
 * Copyright Txus Ballesteros 2015 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */

package com.mobandme.sample.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mobandme.android.transformer.Transformer;
import com.mobandme.sample.app.domain.Home;
import com.mobandme.sample.app.model.HomeModel;
import com.mobandme.sample.app.model.mapper.MyHomeModelMapper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            Home home = null;
            HomeModel homeModel = new HomeModel();
            homeModel.Address = "My Street, 65, 3";
            homeModel.City = "Bilbao";
            homeModel.Country = "Spain";
            homeModel.PostalCode = "48903";

            home = (Home)Transformer.transform(homeModel);
            homeModel = (HomeModel)Transformer.transform(home);
            
            Toast.makeText(this, String.format("Transformed %s --> %s", homeModel.getClass().getSimpleName(), home.getClass().getSimpleName()), Toast.LENGTH_SHORT).show();
            
        } catch (Exception e) {
            Log.e("android-transformer", e.getMessage(), e);
        }
    }
}
