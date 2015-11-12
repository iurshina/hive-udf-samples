package epam.iarysh

import org.apache.hadoop.hive.ql.exec.UDF
import org.apache.hadoop.io.Text

class BrowserExtracting extends UDF {

    public Map<String, String> evaluate(Text str) {
        if (str == null) {
            return null
        }

        def tokens = str.toString().split("\\t")
        def clientInfo = tokens[4].split("\\(")

        [
                type: "Browser",
                family: clientInfo[0]?.trim(),
                os: clientInfo[1]?.split(";")[2]?.trim(),
                device: "Personal Computer"
        ]
    }

}
