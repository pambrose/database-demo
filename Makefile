default: versioncheck

clean:
	./gradlew clean

compile:
	./gradlew build -xtest

versioncheck:
	./gradlew dependencyUpdates

depends:
	./gradlew dependencies

upgrade-wrapper:
	./gradlew wrapper --gradle-version=7.4-rc-1 --distribution-type=bin