package org.agamotto.cloud.demo.service;

/**
 * 〈〉
 *
 * @author wenqiangdong
 * @date 2019-08-12
 */
public interface TokenService {

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    Boolean checkToken(String token);


    /**
     * 创建token
     * @param authObject
     * @return
     */
    String createJWTByObj(Object authObject);

    /**
     * 注销token
     * @param token
     * @return
     */
    Boolean removeToken(String token);

    }
