#!/bin/bash
releases=$(curl -s https://api.github.com/repos/enolgor/gateway/releases | jq -r '.[].tag_name')
release_not_exists=$(echo "$releases" | grep -q "0.6.2"; echo $?;)
if [ "$release_not_exists" -eq "1" ]; then exit 0; else exit 1; fi
