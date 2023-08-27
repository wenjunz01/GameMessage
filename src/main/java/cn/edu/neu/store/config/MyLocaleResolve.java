package cn.edu.neu.store.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolve implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");
        //System.out.println("debug===========>"+language);
        Locale locale = Locale.getDefault();//没有就使用默认的
        if (!StringUtils.isEmpty(language)){//请求链接带了国际化参数
            String[] split = language.split("_");
            //   System.out.println("debug===========>"+split[0]);
            locale = new Locale(split[0],split[1]); //language,国家
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

}
