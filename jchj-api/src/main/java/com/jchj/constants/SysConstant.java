package com.jchj.constants;

/**
 * @Author Sasuke
 * @Title: SysConstant
 * @Description: 系统常量
 * @ProjectName rlt
 * @Date 2020/2/15 14:54
 */
public class SysConstant {

    public static final String FILE_SEPARATOR = "/";

    public static final String DEFAULT_CHARSET = "UTF-8";

    // admin
    public static final String ADMIN = "admin";

    public static final Integer RUN_TIME_EXCEPTION_CODE = 1001;
    public static final String RUN_TIME_EXCEPTION_MSG = "运行时异常";

    // 二维码
    public static final String QR_CODE = "QRCODE_";

    // 文件后缀_jpeg
    public static final String SUFFIX_JPEG = ".jpeg";

    /**
     * 状态 0初始,1未启用,2正常/成功,3已删除/失败
     */
    public enum Status {
        INITIAL(0, "未启用"), UNUSED(1, "未启用"),
        NORMAL(2, "正常"), DELETED(3, "已删除/失败");

        private Integer code;
        private String name;

        Status(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 微服务前缀
     */
    public enum RestServer {
        MYSQLDATA("http://RLT-MYSQLDATA", "MYSQLDATA服务");

        private String urlPrefix;
        private String description;

        RestServer(String urlPrefix, String description) {
            this.urlPrefix = urlPrefix;
            this.description = description;
        }

        public String buildUrl(String uri) {
            return urlPrefix + uri;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }
    }

    /**
     * 系统环境
     */
    public enum SysEnvironment {
        LOCAL("local", "本地环境"),
        DEV("dev", "开发环境"),
        SIT("sit", "测试环境"),
        UAT("uat", "用户测试环境"),
        PROD("prod", "生产环境");

        private String code;
        private String name;

        SysEnvironment(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

}
