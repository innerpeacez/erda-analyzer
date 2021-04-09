// Copyright (c) 2021 Terminus, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package cloud.erda.analyzer.alert.templates.formatters;

import cloud.erda.analyzer.alert.utils.NumberUtils;
import cloud.erda.analyzer.common.utils.StringUtil;

/**
 * @author: liuhaoyang
 * @create: 2020-02-02 20:43
 **/
public class FractionTemplateFormatter implements TemplateFormatter {

    public static final String DEFAULT_DEFINE = TemplateFormatterDefine.FRACTION + ":1";

    private int fraction = 0;

    public FractionTemplateFormatter(String unit) {
        if (!StringUtil.isEmpty(unit)) {
            try {
                fraction = Integer.parseInt(unit);
            } catch (Exception ignore) {
            }
        }
    }

    @Override
    public String formatter() {
        return TemplateFormatterDefine.FRACTION;
    }

    @Override
    public Object format(Object value) {
        if (value instanceof Number) {
            return NumberUtils.formatDouble(((Number) value).doubleValue(), fraction);
        }
        return value;
    }
}
