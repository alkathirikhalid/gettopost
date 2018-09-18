/*
 * Copyright 2018 Al-Kathiri Khalid www.alkathirikhalid.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alkathirikhalid.gettopost;

import android.net.Uri;
import android.webkit.WebView;

import java.util.Set;

/**
 * <p>Get to Post for Android Web View utility.</p>
 * <p>
 * Convert any HTTP URL with Parameters (Get) to Post for Web Views
 * by using <code>GetToPost.convert(String url, WebView webView)</code>.</p>
 *
 * @author alkathirikhalid
 * @version 1.01
 */

public class GetToPost {
    /**
     * Perform conversion and Post data to Web View.
     *
     * @param url     the web link with parameter query.
     * @param webView the web view to receive the converted data.
     */
    public static void convert(String url, WebView webView) {
        // Converts the URL String into Uniform Resource Identifier
        Uri uri = Uri.parse(url);
        // Holder for all the unique names of all query parameters if any
        Set<String> args = uri.getQueryParameterNames();
        // Holder for all the extracted and constructed query parameters from Get to Post format
        StringBuilder params = new StringBuilder();
        // Loop through all the unique name set
        for (String param : args) {
            // If first time looping
            if (params.toString().equals("")) {
                // Add Key and Value of the Parameter
                params.append(param).append("=").append(uri.getQueryParameter(param));
                // For consecutive loops
            } else {
                // Add Ampersand the the Key and Value of the Parameter
                params.append("&").append(param).append("=").append(uri.getQueryParameter(param));
            }
        }
        // Reconstruct the URI into URL and Perform Post to Web View
        webView.postUrl(uri.getScheme() + "://" + uri.getAuthority() + uri.getPath(), params.toString().getBytes());
    }
}
