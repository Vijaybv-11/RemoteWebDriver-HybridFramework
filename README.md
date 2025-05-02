# 🌐 Remote WebDriver Automation Framework

A flexible, scalable, and cloud-ready **test automation framework** built with **RemoteWebDriver**, designed to support **Selenium Grid**, **cloud execution platforms** (like **BrowserStack**, **Sauce Labs**), and **real-time reporting via ReportPortal.io**. The framework supports execution across multiple browsers, environments, and operating systems, and can run locally or in Docker containers.

---

## 🚀 Framework Highlights

- 🌍 **Remote Execution**: Supports Selenium Grid, BrowserStack, Sauce Labs, and more
- 🐳 **Dockerized Selenium Grid**: Easily run Grid and Nodes locally with Docker Compose
- 📊 **ReportPortal Integration**: Real-time, centralized test execution reporting
- 🧪 **Cross-Browser Testing**: Chrome, Firefox, Safari, and Edge supported
- 🧰 **Flexible Configuration**: Easily toggle between local and remote setups
- ⚙️ **CI/CD Friendly**: Integrates seamlessly with Jenkins, GitHub Actions, GitLab CI, etc.
- 🧩 **Cloud Platform Agnostic**: Run tests on any Selenium-compatible cloud platform

---

## 📁 Project Structure
/src
└── /main/java # Application code (if any)
└── /test/java # Test code (TestNG or JUnit based)
└── /resources
├── config.properties # Global settings (browser, environment, remote URL)
├── capabilities.json # JSON capabilities for BrowserStack/Sauce Labs
├── /DockerProperties
│ └── docker.properties # Docker-specific config for grid execution
├── /LambdaTestConfig
│ └── lambdatestconfig.properties # LambdaTest-specific credentials and settings
├── /ReportPortalProperties
│ └── reportportal.properties # Config for ReportPortal endpoint, project, UUID
/docker
└── docker-compose.yml # Spins up Selenium Grid with Hub and Nodes

