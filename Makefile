CPU_COUNT=2
GRADLE_VERSION=6.5
GRADLE_CONTAINER_NAME=gradle-$(shell basename "$$PWD")
CONTAINER_NAME=$(shell basename "$$PWD")
EXPOSE_PORT=8888
LOCAL_USER_DIR=$(shell echo $${HOME})

__GRADLE_IMAGE_TAG=gradle:6.5.0-jdk14

docker_prefix=docker run -i -t \
	--rm \
	--cpus $(CPU_COUNT).00 \
	--name $(GRADLE_CONTAINER_NAME) \
	--memory 8g \
	--memory-reservation 1g \
	--memory-swap 0 \
	--user gradle \
	-p 8888:8080 \
	-v gradle-cache:/home/gradle/.gradle \
	-v m2-cache:/home/gradle/.m2 \
	-v $(shell pwd):/project_dir \
	-w /project_dir \

gradle=$(docker_prefix) \
	--entrypoint gradle \
	$(__GRADLE_IMAGE_TAG) \
	--no-daemon \
	--stacktrace \
	--parallel \
	--max-workers $(CPU_COUNT)

container=$(docker_prefix) \
	--entrypoint bash \
	$(__GRADLE_IMAGE_TAG)

rm:
	for i in $$(find $(shell pwd) -type d -iname 'build'); do rm -rf $$i; done; \
	for i in $$(find $(shell pwd) -type d -iname 'bin'); do rm -rf $$i; done; \
	for i in $$(find $(shell pwd) -type f -iname '.project'); do rm -rf $$i; done; \
	for i in $$(find $(shell pwd) -type f -iname '.classpath'); do rm -rf $$i; done; \
	rm -rf \
		$(shell pwd)/gradle/wrapper \
		$(shell pwd)/.gradle \
		$(shell pwd)/gradlew*

container:
	$(container)

wrapper: rm
	$(gradle) wrapper \
		--gradle-version $(GRADLE_VERSION) \
		--distribution-type all

compile:
	$(gradle) clean testClasses

test:
	$(gradle) clean test
