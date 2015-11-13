package epam.iarysh

import eu.bitwalker.useragentutils.UserAgent
import org.apache.hadoop.hive.ql.exec.UDF

class BrowserExtracting extends UDF {

    public Map<String, String> evaluate(String str) {
        if (str == null) {
            return null
        }

        def tokens = str.split("\\t")

        if (tokens.size() < 8) {
            return null
        }

        def userAgentString = tokens[4]
        def city = tokens[7]

        def userAgent = new UserAgent(userAgentString)

        [
                type  : userAgent?.browser?.browserType?.name,
                browser: userAgent?.browser?.name,
                os    : userAgent?.operatingSystem?.name,
                device: userAgent?.operatingSystem?.deviceType?.name,
                city: city
        ]
    }

}
