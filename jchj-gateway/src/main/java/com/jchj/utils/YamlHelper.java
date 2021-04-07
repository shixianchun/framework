package com.jchj.utils;

import org.yaml.snakeyaml.Yaml;

/**
 * @author shixianchun
 * @Title: YamlHelper
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/79:56 AM
 */
public class YamlHelper {

    private YamlHelper() {}
    public static Yaml getInstance() {
        return InnerClass.YAML;
    }

    private static class InnerClass {
        private static final Yaml YAML = new Yaml();
    }
}
