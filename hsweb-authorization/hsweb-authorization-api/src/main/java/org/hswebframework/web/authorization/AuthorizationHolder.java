/*
 *  Copyright 2016 http://www.hswebframework.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.hswebframework.web.authorization;

/**
 * 权限获取器,用于静态方式获取当前登录用户的权限信息.
 * 例如:
 * <pre>
 *     &#064;RequestMapping("/example")
 *     public ResponseMessage example(){
 *         Authorization auth = AuthorizationHolder.get();
 *         return ResponseMessage.ok();
 *     }
 * </pre>
 *
 * @author zhouhao
 * @see AuthorizationSupplier
 * @since 3.0
 */
public final class AuthorizationHolder {
    private static AuthorizationSupplier supplier;

    /**
     * @return 当前登录用户信息
     */
    public static Authorization get() {
        if (null == supplier) {
            throw new UnsupportedOperationException("AuthorizationSupplier is null!");
        }
        return supplier.get();
    }

    public static void setSupplier(AuthorizationSupplier supplier) {
        if (null == AuthorizationHolder.supplier)
            AuthorizationHolder.supplier = supplier;
    }
}
