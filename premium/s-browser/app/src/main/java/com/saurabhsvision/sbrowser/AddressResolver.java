package com.saurabhsvision.sbrowser;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/** Secure address resolution without network access. Explicit HTTP is upgraded to HTTPS. */
public final class AddressResolver {
    private AddressResolver() {}
    public static String resolve(String typed, String engine) {
        String text = typed == null ? "" : typed.trim();
        if (text.isEmpty()) return null;
        for(int i=0;i<text.length();i++)if(Character.isISOControl(text.charAt(i)))return null;
        String lc = text.toLowerCase(Locale.ROOT);
        if(lc.startsWith("https://")||lc.startsWith("http://")){
            return secureUrl("https://"+text.substring(text.indexOf("://")+3));
        }
        if(lc.contains("://")||text.indexOf('\\')>=0||
           lc.matches("^[a-z][a-z0-9+.-]*:.*") && !text.matches("(?i)^[a-z0-9][a-z0-9.-]*\\.[a-z]{2,}:[0-9]{1,5}([/?#].*)?$"))return null;
        if(text.matches("(?i)^[a-z0-9][a-z0-9.-]*\\.[a-z]{2,}(:[0-9]{1,5})?([/?#][^ ]*)?$"))
            return secureUrl("https://"+text);
        String query = URLEncoder.encode(text, StandardCharsets.UTF_8);
        if ("duckduckgo".equalsIgnoreCase(engine)) return "https://duckduckgo.com/?q=" + query;
        if ("bing".equalsIgnoreCase(engine)) return "https://www.bing.com/search?q=" + query;
        return "https://www.google.com/search?q=" + query;
    }
    public static String secureUrl(String url){
        if(url==null||url.indexOf('\\')>=0)return null;
        try{
            URI u=new URI(url);
            if(!"https".equalsIgnoreCase(u.getScheme())||u.getHost()==null||u.getRawUserInfo()!=null||
               u.getPort()>65535||u.getPort()==0||u.getRawAuthority().endsWith(":"))return null;
            return url;
        }catch(Exception e){return null;}
    }
}
