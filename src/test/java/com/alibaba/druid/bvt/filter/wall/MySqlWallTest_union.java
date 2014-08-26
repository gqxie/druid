/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.filter.wall;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallUtils;

public class MySqlWallTest_union extends TestCase {

    public void testUnion() throws Exception {
        WallConfig config = new WallConfig();
        config.setSelectUnionCheck(true);

        Assert.assertFalse(WallUtils.isValidateMySql("select f1, f2 from t union select 1, 2", config));

        Assert.assertFalse(WallUtils.isValidateMySql("select f1, f2 from t union select null, '1', 2", config));

        Assert.assertTrue(WallUtils.isValidateMySql("select f1, f2 from t union select c1, c2", config));

    }
}
