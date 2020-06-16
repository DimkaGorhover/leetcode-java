CPU_COUNT=2
GRADLE_VERSION=5.6.4
DOCKER_ORG=dier
GRADLE_CONTAINER_NAME=gradle-$(shell basename "$$PWD")
CONTAINER_NAME=$(shell basename "$$PWD")

EXPOSE_PORT=8888
LOCAL_USER_DIR=$(shell echo $${HOME})

# __GRADLE_IMAGE_TAG=$(DOCKER_ORG)/gradle:$(GRADLE_VERSION)-graalvm
__GRADLE_IMAGE_TAG=$(DOCKER_ORG)/gradle:6.5-graalvm

gradle=docker run -i -t \
	--rm \
	--cpus $(CPU_COUNT).00 \
	--name $(GRADLE_CONTAINER_NAME) \
	--memory 8g \
	--memory-reservation 2g \
	--memory-swap 0 \
	--user gradle \
	-p 8888:8080 \
	-v gradle-cache:/home/gradle/.gradle \
	-v m2-cache:/home/gradle/.m2 \
	-v $(shell pwd):/project_dir \
	-w /project_dir \
	--entrypoint gradle \
	$(__GRADLE_IMAGE_TAG) \
	--no-daemon \
	--stacktrace \
	--parallel \
	--max-workers $(CPU_COUNT)

rm:
	rm -rf \
		$(shell pwd)/gradle/wrapper \
		$(shell pwd)/.gradle \
		$(shell pwd)/gradlew*

wrapper: rm
	$(gradle) wrapper \
		--gradle-version $(GRADLE_VERSION) \
		--distribution-type all

compile:
	$(gradle) clean testClasses

test:
	$(gradle) clean test
