package epam.iarysh

import org.apache.hadoop.io.Text
import org.junit.Test

import static junit.framework.TestCase.assertEquals

class BrowserExtractingTest {

    def CASES = [
            "2e72d1bd7185fb76d69c852c57436d37\t20131019025500549\t1\tCAD06D3WCtf\tMozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)\t113.117.187.*\t216\t234\t2\t33235ca84c5fee9254e6512a41b3ad5e\t8bbb5a81cc3d680dd0c27cf4886ddeae\tnull\t3061584349\t728\t90\tOtherView\tNa\t5\t7330\t277\t48\tnull\t2259\t10057,13800,13496,10079,10076,10075,10093,10129,10024,10006,10110,13776,10146,10120,10115,10063",
            "f9f5d9f335ca8d9fc37e736567bcfc1\t20131019163900673\t1\tDAJDulBMexw1\tMozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)\t113.90.24.*\t216\t219\t1\t20fc675468712705dbf5d3eda94126da\t71da4a502bbe17528b773fc681533c2\tnull\tmm_10982364_973726_8930541\t300\t250\tFourthView\tNa\t0\t7323\t294\t27\tnull\t2259\tnull",
            "cfefabfd79f7718bf2eb018a6ae87ada\t20131019152601033\t1\tDAJDVG9QfAIt\tMozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)\t183.63.58.*\t216\t230\t1\t1f0ccf148010fa49de9ddea52db3ebef\t79e84fbeab65f0bf8887ab154647c72\tnull\tmm_32538462_3424141_13492856\t300\t250\tNa\tNa\t0\t7323\t294\t17\tnull\t2259\tnull"
    ]

    def EXPECTED = [
            [browser: "Internet Explorer 6", os: "Windows XP", type: "Browser", device: "Computer", city: "234"],
            [browser: "Internet Explorer 9", os: "Windows 7", type: "Browser", device: "Computer", city: "219"],
            [browser: "Internet Explorer 6", os: "Windows XP", type: "Browser", device: "Computer", city: "230"]
    ]

    @Test
    void testEvaluate() {
        def client = new BrowserExtracting()

        CASES.eachWithIndex { entry, i ->
            def result = client.evaluate(entry)
            assertEquals result, EXPECTED.get(i)
        }
    }
}
