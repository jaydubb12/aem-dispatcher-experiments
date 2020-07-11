/*
Copyright 2020 Adobe. All rights reserved.
This file is licensed to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy
of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
OF ANY KIND, either express or implied. See the License for the specific language
governing permissions and limitations under the License.
*/
package com.brucelefebvre.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class ExpensiveComponentModel {

    @Inject
    private String sleeptime;

    public String getData() throws InterruptedException {
        // Sleep for `sleeptime` milliseconds to simulate a very long running request
        int sleepFor;
        try {
            sleepFor = Integer.parseInt(sleeptime);
        }
        catch (NumberFormatException e) {
            // unable to parse supplied prop
            sleepFor = 0; // 0 millisecond default
        }

        Thread.sleep(sleepFor);

        return "Done!";
    }

}