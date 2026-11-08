package com.hussain.isp;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = getBridge().getWebView();
        // الاسم AndroidApp يطابق ما يستدعيه الكود: window.AndroidApp.printDocument()
        webView.addJavascriptInterface(new PrintBridge(this, webView), "AndroidApp");
    }

    /** جسر الطباعة بين صفحة الويب ونظام الطباعة في أندرويد (طباعة / حفظ PDF) */
    public static class PrintBridge {
        private final Context context;
        private final WebView webView;

        PrintBridge(Context context, WebView webView) {
            this.context = context;
            this.webView = webView;
        }

        @JavascriptInterface
        public void printDocument() {
            webView.post(() -> {
                try {
                    PrintManager printManager =
                        (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
                    if (printManager == null) return;
                    String jobName = "Hussain-ISP-Report";
                    PrintDocumentAdapter adapter = webView.createPrintDocumentAdapter(jobName);
                    printManager.print(jobName, adapter, new PrintAttributes.Builder().build());
                } catch (Exception ignored) {
                }
            });
        }
    }
}
