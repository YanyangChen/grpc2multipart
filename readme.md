<!DOCTYPE html>
<html class="devise-layout-html">
<head prefix="og: http://ogp.me/ns#">
<meta charset="utf-8">
<title>Sign in · GitLab</title>
<link rel="preload" href="/assets/application_utilities-bc405f753d3fc57a7c9cf1aafc04c07ef4c758eced90f0d06275492f20f8fcbf.css" as="style" type="text/css">
<link rel="preload" href="/assets/application-6cbb01bf749e401b7f580040ef7df64328f65f40292b6df5b3384909f1b6bd88.css" as="style" type="text/css">
<link rel="preload" href="/assets/highlight/themes/white-69223daaf028b2b7665d7b9256b5d2f2703ce7f83cb2b7c86479acaf55a59001.css" as="style" type="text/css">

<meta content="IE=edge" http-equiv="X-UA-Compatible">


<link rel="shortcut icon" type="image/png" href="/assets/favicon-72a2cad5025aa931d6ea56c3201d1f18e68a8cd39788c7c80d5b2b82aa5143ef.png" id="favicon" data-original-href="/assets/favicon-72a2cad5025aa931d6ea56c3201d1f18e68a8cd39788c7c80d5b2b82aa5143ef.png" />
<style>
@keyframes blinking-dot{0%{opacity:1}25%{opacity:0.4}75%{opacity:0.4}100%{opacity:1}}@keyframes blinking-scroll-button{0%{opacity:0.2}50%{opacity:1}100%{opacity:0.2}}@keyframes gl-spinner-rotate{0%{transform:rotate(0)}100%{transform:rotate(360deg)}}body.ui-indigo{--gl-theme-accent: #6666c4}body.ui-indigo .navbar-gitlab{background-color:#292961}body.ui-indigo .navbar-gitlab .navbar-collapse{color:#d1d1f0}body.ui-indigo .navbar-gitlab .container-fluid .navbar-toggler{border-left:1px solid #6868b9;color:#d1d1f0}body.ui-indigo .navbar-gitlab .navbar-sub-nav>li>a:hover,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li>a:focus,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li>button:hover,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li>button:focus,body.ui-indigo .navbar-gitlab .navbar-nav>li>a:hover,body.ui-indigo .navbar-gitlab .navbar-nav>li>a:focus,body.ui-indigo .navbar-gitlab .navbar-nav>li>button:hover,body.ui-indigo .navbar-gitlab .navbar-nav>li>button:focus{background-color:rgba(209,209,240,0.2)}body.ui-indigo .navbar-gitlab .navbar-sub-nav>li.active>a,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li.active>button,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li.dropdown.show>a,body.ui-indigo .navbar-gitlab .navbar-sub-nav>li.dropdown.show>button,body.ui-indigo .navbar-gitlab .navbar-nav>li.active>a,body.ui-indigo .navbar-gitlab .navbar-nav>li.active>button,body.ui-indigo .navbar-gitlab .navbar-nav>li.dropdown.show>a,body.ui-indigo .navbar-gitlab .navbar-nav>li.dropdown.show>button{color:#292961;background-color:#fff}body.ui-indigo .navbar-gitlab .navbar-sub-nav>li.line-separator,body.ui-indigo .navbar-gitlab .navbar-nav>li.line-separator{border-left:1px solid rgba(209,209,240,0.2)}body.ui-indigo .navbar-gitlab .navbar-sub-nav{color:#d1d1f0}body.ui-indigo .navbar-gitlab .nav>li{color:#d1d1f0}body.ui-indigo .navbar-gitlab .nav>li.header-search-new{color:#303030}body.ui-indigo .navbar-gitlab .nav>li>a .notification-dot{border:2px solid #292961}body.ui-indigo .navbar-gitlab .nav>li>a.header-help-dropdown-toggle .notification-dot{background-color:#d1d1f0}body.ui-indigo .navbar-gitlab .nav>li>a.header-user-dropdown-toggle .header-user-avatar{border-color:#d1d1f0}@media (min-width: 576px){body.ui-indigo .navbar-gitlab .nav>li>a:hover,body.ui-indigo .navbar-gitlab .nav>li>a:focus{background-color:rgba(209,209,240,0.2)}}body.ui-indigo .navbar-gitlab .nav>li>a:hover svg,body.ui-indigo .navbar-gitlab .nav>li>a:focus svg{fill:currentColor}body.ui-indigo .navbar-gitlab .nav>li>a:hover .notification-dot,body.ui-indigo .navbar-gitlab .nav>li>a:focus .notification-dot{will-change:border-color, background-color;border-color:#4a4a82}body.ui-indigo .navbar-gitlab .nav>li>a.header-help-dropdown-toggle:hover .notification-dot,body.ui-indigo .navbar-gitlab .nav>li>a.header-help-dropdown-toggle:focus .notification-dot{background-color:#fff}body.ui-indigo .navbar-gitlab .nav>li.active>a,body.ui-indigo .navbar-gitlab .nav>li.dropdown.show>a{color:#292961;background-color:#fff}body.ui-indigo .navbar-gitlab .nav>li.active>a:hover svg,body.ui-indigo .navbar-gitlab .nav>li.dropdown.show>a:hover svg{fill:#292961}body.ui-indigo .navbar-gitlab .nav>li.active>a .notification-dot,body.ui-indigo .navbar-gitlab .nav>li.dropdown.show>a .notification-dot{border-color:#fff}body.ui-indigo .navbar-gitlab .nav>li.active>a.header-help-dropdown-toggle .notification-dot,body.ui-indigo .navbar-gitlab .nav>li.dropdown.show>a.header-help-dropdown-toggle .notification-dot{background-color:#292961}body.ui-indigo .navbar-gitlab .nav>li .impersonated-user svg,body.ui-indigo .navbar-gitlab .nav>li .impersonated-user:hover svg{fill:#292961}body.ui-indigo .navbar .title>a:hover,body.ui-indigo .navbar .title>a:focus{background-color:rgba(209,209,240,0.2)}body.ui-indigo .header-search{background-color:rgba(209,209,240,0.2) !important;border-radius:4px}body.ui-indigo .header-search:hover{background-color:rgba(209,209,240,0.3) !important}body.ui-indigo .header-search svg.gl-search-box-by-type-search-icon{color:rgba(209,209,240,0.8)}body.ui-indigo .header-search input{background-color:transparent;color:rgba(209,209,240,0.8);box-shadow:inset 0 0 0 1px rgba(209,209,240,0.4)}body.ui-indigo .header-search input::placeholder{color:rgba(209,209,240,0.8)}body.ui-indigo .header-search input:focus::placeholder,body.ui-indigo .header-search input:active::placeholder{color:#868686}body.ui-indigo .header-search .keyboard-shortcut-helper{color:#d1d1f0;background-color:rgba(209,209,240,0.2)}body.ui-indigo .search form{background-color:rgba(209,209,240,0.2)}body.ui-indigo .search form:hover{background-color:rgba(209,209,240,0.3)}body.ui-indigo .search .search-input::placeholder{color:rgba(209,209,240,0.8)}body.ui-indigo .search .search-input-wrap .search-icon,body.ui-indigo .search .search-input-wrap .clear-icon{fill:rgba(209,209,240,0.8)}body.ui-indigo .search.search-active form{background-color:#fff}body.ui-indigo .search.search-active .search-input-wrap .search-icon{fill:rgba(209,209,240,0.8)}body.ui-indigo .nav-sidebar li.active>a{color:#303030}body.ui-indigo .nav-sidebar .fly-out-top-item a,body.ui-indigo .nav-sidebar .fly-out-top-item a:hover,body.ui-indigo .nav-sidebar .fly-out-top-item.active a,body.ui-indigo .nav-sidebar .fly-out-top-item .fly-out-top-item-container{background-color:var(--gray-100, #f0f0f0);color:var(--gray-900, #303030)}body.ui-indigo .branch-header-title{color:#4b4ba3}body.ui-indigo .ide-sidebar-link.active{color:#4b4ba3}body.ui-indigo .ide-sidebar-link.active.is-right{box-shadow:inset -3px 0 #4b4ba3}

*,*::before,*::after{box-sizing:border-box}html{font-family:sans-serif;line-height:1.15}body{margin:0;font-family:-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Noto Sans", Ubuntu, Cantarell, "Helvetica Neue", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";font-size:1rem;font-weight:400;line-height:1.5;color:#303030;text-align:left;background-color:#fff}hr{box-sizing:content-box;height:0;overflow:visible}h1{margin-top:0;margin-bottom:0.25rem}p{margin-top:0;margin-bottom:1rem}a{color:#007bff;text-decoration:none;background-color:transparent}a:not([href]):not([class]){color:inherit;text-decoration:none}img{vertical-align:middle;border-style:none}label{display:inline-block;margin-bottom:0.5rem}input{margin:0;font-family:inherit;font-size:inherit;line-height:inherit}input{overflow:visible}[type="submit"]:not(:disabled){cursor:pointer}[type="submit"]::-moz-focus-inner{padding:0;border-style:none}fieldset{min-width:0;padding:0;margin:0;border:0}[hidden]{display:none !important}h1{margin-bottom:0.25rem;font-weight:600;line-height:1.2;color:#303030}h1{font-size:2.1875rem}hr{margin-top:0.5rem;margin-bottom:0.5rem;border:0;border-top:1px solid rgba(0,0,0,0.1)}.container{width:100%;padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}@media (min-width: 576px){.container{max-width:540px}}@media (min-width: 768px){.container{max-width:720px}}@media (min-width: 992px){.container{max-width:960px}}@media (min-width: 1200px){.container{max-width:1140px}}.col-sm-12,.col{position:relative;width:100%;padding-right:15px;padding-left:15px}.col{flex-basis:0;flex-grow:1;max-width:100%}@media (min-width: 576px){.col-sm-12{flex:0 0 100%;max-width:100%}}.form-control{display:block;width:100%;height:34px;padding:0.375rem 0.75rem;font-size:0.875rem;font-weight:400;line-height:1.5;color:#303030;background-color:#fff;background-clip:padding-box;border:1px solid #868686;border-radius:0.25rem}.form-control:-moz-focusring{color:transparent;text-shadow:0 0 0 #303030}.form-control::placeholder{color:#5e5e5e;opacity:1}.form-control:disabled{background-color:#fafafa;opacity:1}.form-group{margin-bottom:1rem}.form-row{display:flex;flex-wrap:wrap;margin-right:-5px;margin-left:-5px}.form-row>.col{padding-right:5px;padding-left:5px}.btn{display:inline-block;font-weight:400;color:#303030;text-align:center;vertical-align:middle;-webkit-user-select:none;user-select:none;background-color:transparent;border:1px solid transparent;padding:0.375rem 0.75rem;font-size:1rem;line-height:20px;border-radius:0.25rem}.btn:disabled{opacity:0.65}.btn:not(:disabled):not(.disabled){cursor:pointer}fieldset:disabled a.btn{pointer-events:none}.mt-3{margin-top:1rem !important}.mb-3{margin-bottom:1rem !important}.text-nowrap{white-space:nowrap !important}.text-center{text-align:center !important}.gl-form-input,.gl-form-input.form-control{background-color:#fff;font-family:-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Noto Sans", Ubuntu, Cantarell, "Helvetica Neue", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";font-size:0.875rem;line-height:1rem;padding-top:0.5rem;padding-bottom:0.5rem;padding-left:0.75rem;padding-right:0.75rem;height:auto;color:#303030;box-shadow:inset 0 0 0 1px #868686;border-style:none;-webkit-appearance:none;appearance:none;-moz-appearance:none}.gl-form-input:disabled,.gl-form-input:not(.form-control-plaintext):not([type="color"]):read-only,.gl-form-input.form-control:disabled,.gl-form-input.form-control:not(.form-control-plaintext):not([type="color"]):read-only{background-color:#f5f5f5;box-shadow:inset 0 0 0 1px #dbdbdb}.gl-form-input:disabled,.gl-form-input.form-control:disabled{cursor:not-allowed;color:#868686}.gl-form-input::placeholder,.gl-form-input.form-control::placeholder{color:#868686}.gl-button{display:inline-flex}.gl-button:not(.btn-link):active{text-decoration:none}.gl-button.gl-button{border-width:0;padding-top:0.5rem;padding-bottom:0.5rem;padding-left:0.75rem;padding-right:0.75rem;background-color:transparent;line-height:1rem;color:#303030;fill:currentColor;box-shadow:inset 0 0 0 1px #bfbfbf;justify-content:center;align-items:center;font-size:0.875rem;border-radius:0.25rem}.gl-button.gl-button .gl-button-text{overflow:hidden;text-overflow:ellipsis;white-space:nowrap;padding-top:1px;padding-bottom:1px;margin-top:-1px;margin-bottom:-1px}.gl-button.gl-button .gl-button-icon{height:1rem;width:1rem;flex-shrink:0;margin-right:0.25rem;top:auto}.gl-button.gl-button.btn-default{background-color:#fff}.gl-button.gl-button.btn-default:active{box-shadow:inset 0 0 0 1px #5e5e5e, 0 0 0 1px #fff, 0 0 0 3px #428fdc;outline:none;background-color:#dbdbdb}.gl-button.gl-button.btn-confirm{color:#fff}.gl-button.gl-button.btn-confirm{background-color:#1f75cb;box-shadow:inset 0 0 0 1px #1068bf}.gl-button.gl-button.btn-confirm:active{box-shadow:inset 0 0 0 1px #033464, 0 0 0 1px #fff, 0 0 0 3px #428fdc;outline:none;background-color:#0b5cad}body{font-size:0.875rem}[type="submit"]{cursor:pointer}h1{margin-top:20px;margin-bottom:10px}a{color:#1068bf}hr{overflow:hidden}.form-control{font-size:0.875rem}.hidden{display:none !important;visibility:hidden !important}.hide{display:none}html{overflow-y:scroll}body{text-decoration-skip:ink}body.navless{background-color:#fff !important}.container{padding-top:0;z-index:5}.container .content{margin:0}@media (max-width: 575.98px){.container .content{margin-top:20px}}.navless-container{margin-top:var(--header-height, 48px);padding-top:32px}.btn{border-radius:4px;font-size:0.875rem;font-weight:400;padding:6px 10px;background-color:#fff;border-color:#dbdbdb;color:#303030;color:#303030;white-space:nowrap}.btn:active{background-color:#f0f0f0;box-shadow:none}.btn:active{background-color:#eaeaea;border-color:#e3e3e3;color:#303030}.light{color:#303030}hr{margin:1.5rem 0;border-top:1px solid #eee}.footer-links{margin-bottom:20px}.footer-links a{margin-right:15px}.flash-container{margin:0;margin-bottom:16px;font-size:14px;position:relative;z-index:1}.flash-container.sticky{position:sticky;top:48px;z-index:251}.flash-container.flash-container-page{margin-bottom:0}.flash-container:empty{margin:0}input{border-radius:0.25rem;color:#303030;background-color:#fff}label{font-weight:600}label.label-bold{font-weight:600}.form-control{border-radius:4px;padding:6px 10px}.form-control::placeholder{color:#868686}.gl-show-field-errors .form-control:not(textarea){height:34px}.gl-show-field-errors .gl-field-hint{color:#303030}input::-moz-placeholder{color:#868686;opacity:1}input::-ms-input-placeholder{color:#868686}input:-ms-input-placeholder{color:#868686}.login-page .container{max-width:960px}.login-page .navbar-gitlab .container{max-width:none}.login-page .flash-container{margin-bottom:16px;position:relative;top:8px}.login-page .brand-holder{font-size:18px;line-height:1.5}.login-page .brand-holder p{font-size:16px;color:#888}.login-page .brand-holder h3{font-size:22px}.login-page .brand-holder img{max-width:100%;margin-bottom:30px}.login-page .brand-holder a{font-weight:600}.login-page p{font-size:13px}.login-page .borderless .login-box,.login-page .borderless .omniauth-container{box-shadow:none}.login-page .borderless .g-recaptcha>div{margin-left:auto;margin-right:auto}.login-page .login-box,.login-page .omniauth-container{box-shadow:0 0 0 1px #dbdbdb;border-radius:0.25rem}.login-page .login-box .login-heading h3,.login-page .omniauth-container .login-heading h3{font-weight:400;line-height:1.5;margin:0 0 10px}.login-page .login-box .login-footer,.login-page .omniauth-container .login-footer{margin-top:10px}.login-page .login-box .login-footer p:last-child,.login-page .omniauth-container .login-footer p:last-child{margin-bottom:0}.login-page .login-box a.forgot,.login-page .omniauth-container a.forgot{float:right;padding-top:6px}.login-page .login-box .nav .active a,.login-page .omniauth-container .nav .active a{background:transparent}.login-page .login-box .login-body,.login-page .omniauth-container .login-body{font-size:13px}.login-page .login-box .login-body input+p,.login-page .login-box .login-body input~p.field-validation,.login-page .omniauth-container .login-body input+p,.login-page .omniauth-container .login-body input~p.field-validation{margin-top:5px}.login-page .login-box .login-body .username .validation-success,.login-page .omniauth-container .login-body .username .validation-success{color:#217645}.login-page .login-box .login-body .username .validation-error,.login-page .omniauth-container .login-body .username .validation-error{color:#dd2b0e}.login-page .omniauth-container{border-radius:0.25rem;font-size:13px}.login-page .omniauth-container p{margin:0}.login-page .omniauth-container form{padding:0;border:0;background:none}.login-page .new-session-tabs{display:flex;box-shadow:0 0 0 1px #dbdbdb;border-top-right-radius:4px;border-top-left-radius:4px}.login-page .new-session-tabs.custom-provider-tabs{flex-wrap:wrap}.login-page .new-session-tabs.custom-provider-tabs li{min-width:85px;flex-basis:auto}.login-page .new-session-tabs.custom-provider-tabs li:nth-child(n + 5){border-top:1px solid #dbdbdb}.login-page .new-session-tabs.custom-provider-tabs a{font-size:16px}.login-page .new-session-tabs li{flex:1;text-align:center;border-left:1px solid #dbdbdb}.login-page .new-session-tabs li:first-of-type{border-left:0;border-top-left-radius:4px}.login-page .new-session-tabs li:last-of-type{border-top-right-radius:4px}.login-page .new-session-tabs li:not(.active){background-color:#fafafa}.login-page .new-session-tabs li a{width:100%;font-size:18px}.login-page .new-session-tabs li.active>a{cursor:default}.login-page .form-control:active,.login-page .form-control:focus{background-color:#fff}.login-page .submit-container{margin-top:16px}.login-page input[type="submit"]{margin-bottom:0;display:block;width:100%}.login-page .devise-errors h2{margin-top:0;font-size:14px;color:#ae1800}@media (max-width: 575.98px){.login-page .col-md-5.float-right{float:none !important;margin-bottom:45px}}.devise-layout-html{margin:0;padding:0;height:100%}.devise-layout-html body{height:calc(100% - 51px);margin:0;padding:0}.devise-layout-html body.navless{height:calc(100% - 11px)}.devise-layout-html body .page-wrap{min-height:100%;position:relative}.devise-layout-html body .footer-container,.devise-layout-html body hr.footer-fixed{position:absolute;bottom:0;left:0;right:0;height:40px;background:#fff}.devise-layout-html body .login-page-broadcast{margin-top:40px}.devise-layout-html body .navless-container{padding:0 15px 65px}.devise-layout-html body .flash-container{padding-bottom:65px}@media (max-width: 575.98px){.devise-layout-html body .flash-container{padding-bottom:0}}.gl-text-green-600{color:#217645}.gl-text-red-500{color:#dd2b0e}.gl-display-block{display:block}.gl-w-10{width:3.5rem}.gl-w-half{width:50%}.gl-w-90p{width:90%}.gl-w-full{width:100%}@media (max-width: 575.98px){.gl-xs-w-full{width:100%}}.gl-p-4{padding:0.75rem}.gl-pt-5{padding-top:1rem}.gl-mt-2{margin-top:0.25rem}.gl-mt-5{margin-top:1rem}.gl-mr-auto{margin-right:auto}.gl-mr-2{margin-right:0.25rem}.gl-mb-1{margin-bottom:0.125rem}.gl-mb-2{margin-bottom:0.25rem}.gl-mb-3{margin-bottom:0.5rem}.gl-mb-5{margin-bottom:1rem}.gl-ml-auto{margin-left:auto}.gl-ml-2{margin-left:0.25rem}.gl-text-center{text-align:center}.gl-font-size-h2{font-size:1.1875rem}.gl-font-weight-normal{font-weight:400}.cloak-startup,.content-wrapper>.alert-wrapper,#content-body,.modal-dialog{display:none}

</style>


<link rel="stylesheet" media="print" href="/assets/application-6cbb01bf749e401b7f580040ef7df64328f65f40292b6df5b3384909f1b6bd88.css" />

<link rel="stylesheet" media="print" href="/assets/application_utilities-bc405f753d3fc57a7c9cf1aafc04c07ef4c758eced90f0d06275492f20f8fcbf.css" />


<link rel="stylesheet" media="print" href="/assets/highlight/themes/white-69223daaf028b2b7665d7b9256b5d2f2703ce7f83cb2b7c86479acaf55a59001.css" />
<script>
//<![CDATA[
document.querySelectorAll('link[media="print"]').forEach(linkTag => {
  linkTag.setAttribute('data-startupcss', 'loading');
  const startupLinkLoadedEvent = new CustomEvent('CSSStartupLinkLoaded');
  linkTag.addEventListener('load',function(){this.media='all';this.setAttribute('data-startupcss', 'loaded');document.dispatchEvent(startupLinkLoadedEvent);},{once: true});
})

//]]>
</script>

<script>
//<![CDATA[
window.gon={};gon.features={"webauthn":true};
//]]>
</script>








<script src="/assets/webpack/runtime.2f7bcc8f.bundle.js" defer="defer"></script>
<script src="/assets/webpack/main.ca5386f4.chunk.js" defer="defer"></script>
<script src="/assets/webpack/commons-pages.admin.sessions-pages.ldap.omniauth_callbacks-pages.omniauth_callbacks-pages.profiles.t-819a5f03.ce898c10.chunk.js" defer="defer"></script>
<script src="/assets/webpack/commons-pages.admin.sessions-pages.sessions-pages.sessions.new.1af512f8.chunk.js" defer="defer"></script>
<script src="/assets/webpack/pages.sessions.new.c4c0ba6b.chunk.js" defer="defer"></script>

<meta content="object" property="og:type">
<meta content="GitLab" property="og:site_name">
<meta content="Sign in · GitLab" property="og:title">
<meta content="GitLab Community Edition" property="og:description">
<meta content="https://gitlab.etaxlab.cloud/assets/twitter_card-570ddb06edf56a2312253c5872489847a0f385112ddbcd71ccfa1570febab5d2.jpg" property="og:image">
<meta content="64" property="og:image:width">
<meta content="64" property="og:image:height">
<meta content="https://gitlab.etaxlab.cloud/users/sign_in" property="og:url">
<meta content="summary" property="twitter:card">
<meta content="Sign in · GitLab" property="twitter:title">
<meta content="GitLab Community Edition" property="twitter:description">
<meta content="https://gitlab.etaxlab.cloud/assets/twitter_card-570ddb06edf56a2312253c5872489847a0f385112ddbcd71ccfa1570febab5d2.jpg" property="twitter:image">

<meta content="GitLab Community Edition" name="description">
<link href="/-/manifest.json" rel="manifest">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<meta content="#292961" name="theme-color">
<meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="ex9ONIyzb9IVHEsRAAJU/ncFw+mP5ZKG6LFGZMh1dJHGRGC153bAqyqVwNkZhxuoN6k3BWubb4skWcxwR6cUOg==" />
<meta name="csp-nonce" />
<meta name="action-cable-url" content="/-/cable" />
<link rel="apple-touch-icon" type="image/x-icon" href="/assets/apple-touch-icon-b049d4bc0dd9626f31db825d61880737befc7835982586d015bded10b4435460.png" />
<link href="/search/opensearch.xml" rel="search" title="Search GitLab" type="application/opensearchdescription+xml">





</head>

<body class="login-page application navless ui-indigo gl-browser-generic gl-platform-other" data-page="sessions:new" data-qa-selector="login_page">

<script>
//<![CDATA[
gl = window.gl || {};
gl.client = {"isGeneric":true,"isOther":true};


//]]>
</script>
<div class="page-wrap">
<header class="navbar fixed-top navbar-empty">
<svg class="tanuki-logo" width="25" height="24" viewBox="0 0 25 24" fill="none" xmlns="http://www.w3.org/2000/svg">
  <path class="tanuki-shape tanuki" d="m24.507 9.5-.034-.09L21.082.562a.896.896 0 0 0-1.694.091l-2.29 7.01H7.825L5.535.653a.898.898 0 0 0-1.694-.09L.451 9.411.416 9.5a6.297 6.297 0 0 0 2.09 7.278l.012.01.03.022 5.16 3.867 2.56 1.935 1.554 1.176a1.051 1.051 0 0 0 1.268 0l1.555-1.176 2.56-1.935 5.197-3.89.014-.01A6.297 6.297 0 0 0 24.507 9.5Z"
        fill="#E24329"/>
  <path class="tanuki-shape right-cheek" d="m24.507 9.5-.034-.09a11.44 11.44 0 0 0-4.56 2.051l-7.447 5.632 4.742 3.584 5.197-3.89.014-.01A6.297 6.297 0 0 0 24.507 9.5Z"
        fill="#FC6D26"/>
  <path class="tanuki-shape chin" d="m7.707 20.677 2.56 1.935 1.555 1.176a1.051 1.051 0 0 0 1.268 0l1.555-1.176 2.56-1.935-4.743-3.584-4.755 3.584Z"
        fill="#FCA326"/>
  <path class="tanuki-shape left-cheek" d="M5.01 11.461a11.43 11.43 0 0 0-4.56-2.05L.416 9.5a6.297 6.297 0 0 0 2.09 7.278l.012.01.03.022 5.16 3.867 4.745-3.584-7.444-5.632Z"
        fill="#FC6D26"/>
</svg>

</header>

<div class="login-page-broadcast">


</div>
<div class="container navless-container">
<div class="content">
<div class="flash-container flash-container-page sticky" data-qa-selector="flash_container">
<div class="flash-alert mb-2" data-testid="alert-danger">
<svg class="s16 align-middle mr-1" data-testid="error-icon"><use href="/assets/icons-cb3e99d32ea6ccc15123fc635733bb435edda525898e27f2026418abad0a3f58.svg#error"></use></svg>
<span>You need to sign in or sign up before continuing.</span>
<div class="close-icon-wrapper js-close-icon">
<svg class="s16 close-icon gl-vertical-align-baseline!" data-testid="close-icon"><use href="/assets/icons-cb3e99d32ea6ccc15123fc635733bb435edda525898e27f2026418abad0a3f58.svg#close"></use></svg>
</div>
</div>
</div>

<div class="row mt-3">
<div class="col-sm-12">
<h1 class="mb-3 font-weight-normal">
GitLab
</h1>
</div>
</div>
<div class="row mb-3">
<div class="col-md-6 order-12 order-sm-1 brand-holder">

<h3 class="gl-sm-mt-0">
A complete DevOps platform
</h3>
<p>
GitLab is a single application for the entire software development lifecycle. From project planning and source code management to CI/CD, monitoring, and security.
</p>
<p>
This is a self-managed instance of GitLab.
</p>

</div>
<div class="col-md-6 order-1 new-session-forms-container order-sm-12">

<div id="signin-container">
<div class="tab-content">
<div class="login-box tab-pane active" id="login-pane" role="tabpanel">
<div class="login-body">
<form class="new_user gl-show-field-errors js-sign-in-form" id="new_user" aria-live="assertive" data-testid="sign-in-form" action="/users/sign_in" accept-charset="UTF-8" method="post"><input type="hidden" name="authenticity_token" value="1YqByNRBUQQNzf11D0LtP/ntc5ou8uiDvtNqHEn0JoBo0a9Jv4T+fTJEdr0Wx6JpuUGHdsqMFY5yO+AIxiZGKw==" autocomplete="off" /><div class="form-group gl-px-5 gl-pt-5">
<label for="user_login" class="label-bold ">Username or email</label>

<input class="form-control gl-form-input top js-username-field" autofocus="autofocus" autocapitalize="off" autocorrect="off" required="required" title="This field is required." data-qa-selector="login_field" data-testid="username-field" type="text" name="user[login]" id="user_login" />
</div>
<div class="form-group gl-px-5">
<label class="label-bold " for="user_password">Password</label>
<input class="form-control gl-form-input bottom" autocomplete="current-password" required="required" title="This field is required." data-qa-selector="password_field" type="password" name="user[password]" id="user_password" />
</div>
<div class="gl-px-5">
<div class="gl-display-inline-block">
<div class="gl-form-checkbox custom-control custom-checkbox">
<input name="user[remember_me]" type="hidden" value="0" autocomplete="off" /><input class="custom-control-input" type="checkbox" value="1" name="user[remember_me]" id="user_remember_me" />
<label class="custom-control-label" for="user_remember_me"><span>Remember me</span></label>
</div>

</div>
<div class="gl-float-right">
<a href="/users/password/new">Forgot your password?</a>
</div>
</div>
<div></div>
<div class="submit-container move-submit-down gl-px-5">
<button name="button" type="submit" class="gl-button btn btn-block btn-confirm js-sign-in-button" data-qa-selector="sign_in_button" data-testid="sign-in-button">Sign in</button>
</div>
</form>
</div>
</div>

</div>
</div>

</div>
</div>
</div>
</div>
<hr class="footer-fixed">
<div class="container footer-container">
<div class="footer-links">
<a href="/explore">Explore</a>
<a href="/help">Help</a>
<a href="https://about.gitlab.com">About GitLab</a>
<a target="_blank" class="text-nowrap" rel="noopener noreferrer" href="https://forum.gitlab.com">Community forum</a>
</div>
</div>


</div>
</body>
</html>
