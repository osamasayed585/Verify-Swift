This is a composable OTP

## Step 1. Add the Verif-Swift library to your build file
Add it to your root build.gradle at the end of repositories:

```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			 maven { url = URI("https://jitpack.io") }
		}
	}
```
## Step 2. Add the dependency

```
dependencies {
	        implementation("com.github.osamasayed585:Verify-Swift:1.0.0")
	}
```
