# Verify swift
Check out Verify-Swift! It's a handy tool for adding secure codes to your app. Use it to match passwords or verification codes easily. You can customize it the way you want, and it works for 4 digits or more. Plus, it's made with 100% Kotlin code! Try it for a safer and simpler app experience.

## Getting Started

## Step 1. Add the Verif-Swift library to your build file

Add it to your root build.gradle at the end of repositories:

```groovy
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			 maven { url = URI("https://jitpack.io") }
		}
	}
```

Add the dependency

```groovy
dependencies {
	        implementation("com.github.osamasayed585:Verify-Swift:1.0.0")
	}
```



