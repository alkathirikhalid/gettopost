package com.alkathirikhalid.gettopost;

import android.net.Uri;
import android.webkit.WebView;

import java.util.Set;

/**
 * Project GetToPostTest
 * Date: 9/18/2018 Time: 3:20 PM
 *
 * @author alkathirikhalid
 */

public class GetToPost {
    public static void convert(String url, WebView webView) {
        Uri uri = Uri.parse(url);
        Set<String> args = uri.getQueryParameterNames();

        StringBuilder params = new StringBuilder();
        for (String param : args) {
            if (params.toString().equals("")) {
                params.append(param).append("=").append(uri.getQueryParameter(param));
            } else {
                params.append("&").append(param).append("=").append(uri.getQueryParameter(param));
            }
        }
        webView.postUrl(uri.getScheme() + "://" + uri.getAuthority() + uri.getPath(), params.toString().getBytes());
    }
}
