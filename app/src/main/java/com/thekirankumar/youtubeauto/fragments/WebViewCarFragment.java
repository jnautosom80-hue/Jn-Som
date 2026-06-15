package com.thekirankumar.youtubeauto.fragments;

import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatio;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.thekirankumar.youtubeauto.R;

public class WebViewCarFragment extends Fragment {
    
    // O seu link oficial e estável da Netlify já configurado como página inicial fixa!
    public static final String YOUTUBE_HOME_URL_BASE = "https://netlify.app";
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview_car, container, false);
        
        webView = view.findViewById(R.id.web_view);
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowFileAccess(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(YOUTUBE_HOME_URL_BASE);
        }
        
        return view;
    }

    @Override
    public void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}
