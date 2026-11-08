# حسين لخدمات الإنترنت — بناء تطبيق APK

مشروع Capacitor يحوّل `www/index.html` إلى تطبيق أندرويد، ويبنيه GitHub Actions تلقائياً.

## الخطوات
1. أنشئ مستودعاً جديداً على GitHub (Repository).
2. ارفع كل محتويات هذا المجلد (بما فيها المجلد المخفي `.github`) إلى الفرع `main`.
3. افتح تبويب **Actions** وانتظر انتهاء "Build Android APK" (حوالي 5–8 دقائق).
4. افتح التشغيل الناجح ← قسم **Artifacts** ← حمّل `Hussain-ISP-APK` ← فك الضغط ← ثبّت `app-debug.apk`.

لإعادة البناء يدوياً: Actions ← Build Android APK ← Run workflow.

## تعديل التطبيق
عدّل `www/index.html` وارفعه، وسيُبنى APK جديد تلقائياً.

## الطباعة
زر الطباعة يستدعي `window.AndroidApp.printDocument()` وقد ربطته بنظام الطباعة في أندرويد (طباعة أو حفظ PDF) عبر `native/MainActivity.java`.

## ملاحظة
التطبيق يعتمد على الإنترنت (Bootstrap وFontAwesome وخط Cairo وJSONBin وتيليجرام).
