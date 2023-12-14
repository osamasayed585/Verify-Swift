<h1 align="center">Verify Swift</h1></br>
<p align="center">
Check out Verify-Swift! It's a handy tool for adding secure codes to your app. Use it to match passwords or verification codes easily. You can customize it the way you want, and it works for 4 digits or more. Plus, it's made with 100% Kotlin code! Try it for a safer and simpler app experience.
</p>
<br>

## Getting Started
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

## License
```xml
MIT License

Copyright (c) 2023 Usama Sayed

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

