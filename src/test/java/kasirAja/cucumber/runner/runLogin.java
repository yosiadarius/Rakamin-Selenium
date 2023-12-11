package kasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//   Script didapat dengan menonton video
//   6. Topik 6 - Integrasi Gherkin dan test case - (6) Cucumber Run & Report
//   https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55920

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/kasirAja/cucumber/resource/features",
        glue = "kasirAja.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"},
        //tags = "@Regression" // Jalankan hanya Feature dengan Tag @Regression
        //tags = "@Negative" // Jalankan hanya Feature dengan Tag @Negative
        tags = "@TDD" // Jalankan hanya Feature dengan Tag @TDD
)
public class runLogin {
}
