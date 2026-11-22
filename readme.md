# Boundary prompts and fault detection in AI-generated JUnit tests

Arshnoor Singh · COMP 3520 · Thompson Rivers University

Does asking an AI to test values just below, at, and above each boundary help it catch more defects? This pilot compared a basic prompt with the same prompt plus that boundary instruction. GPT-6.2 Astra generated JUnit tests for two Java methods. Both prompt conditions detected all three seeded defects after verification.

## Run the project

The experiment used Windows 11, JDK 25.0.1, Maven 3.10.1, and JUnit Jupiter 5.11.4. The project targets Java 21. From the folder containing `pom.xml`, run:

```powershell
mvn test
```

If Maven is installed outside your PATH, use the full path to `mvn.cmd`. The default run executes the suites currently in `src/test/java`. The original generated suites for each prompt are in `suites/basic` and `suites/structured`.

## Reproduce one comparison

Start from a fresh checkout. To run the basic shipping suite in PowerShell:

```powershell
$testDir = "src/test/java/ca/tru/comp3520"
Copy-Item "suites/basic/ShippingPolicyTest.java" "$testDir/ShippingPolicyTest.java"
mvn clean "-Dtest=ShippingPolicyTest" test
```

1. Run the suite on the correct rule. All six basic shipping tests should pass.
2. In `ShippingPolicy.java`, change `orderTotalCents >= 5000` to `orderTotalCents > 5000`. Run the same Maven command again. The test for exactly 5,000 cents should fail.
3. Copy the Surefire text report from `target/surefire-reports` to a separate folder after each run if you want to keep it. Maven reuses the report filename.
4. Restore the correct rule. Repeat with `suites/structured/ShippingPolicyTest.java`. This suite contains nine tests.

For returns, use `ReturnPolicyTest.java` and `-Dtest=ReturnPolicyTest`. Start each run from the correct rule, `daysSincePurchase >= 0 && daysSincePurchase <= 30`. Introduce only one change per faulty run: use `> 0` to exclude day 0, or `< 30` to exclude day 30. Run each variant with both archived suites.

## Recorded results

| Method | Basic suite | Structured suite | Defects detected |
|---|---:|---:|---|
| Shipping | 6 tests | 9 tests | Both caught the $50 threshold defect |
| Returns | 11 tests | 9 tests | Both caught the day-0 and day-30 defects after verification |

The original Maven reports and `pilot-summary.csv` are in `results/`. Both initial day-30 reports showed zero failures. Separate reruns recorded one failure for each prompt at exactly day 30. The cause of the discrepancy is unknown. Both the initial reports and reruns are included.