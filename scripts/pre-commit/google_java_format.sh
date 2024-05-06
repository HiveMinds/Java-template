#!/bin/bash

# Google Java Format .jar url:
JAR_URL="https://github.com/google/google-java-format/releases/download/v1.17.0/google-java-format-1.17.0-all-deps.jar"
# OUTPUT_JAR_FILENAME="google-java-format-all-deps.jar"
OUTPUT_JAR_FILENAME="google-java-format-all-deps.jar"
# OUTPUT_JAR_FILENAME="google-java-format-1.17.0.jar"
JAR_FILEPATH="$PWD/scripts/pre-commit/$OUTPUT_JAR_FILENAME"
# JAR_FILEPATH="$PWD/$OUTPUT_JAR_FILENAME"

# Get arguments to determine on which java files to apply formatting.
ALL_IN_DIR="$1"
TARGET_DIR="$2"
JAVA_FILEPATH_TO_FORMAT=("$@")

# Function to find all .java files in a directory and its subdirectories
# Usage: find_java_files some_path/
# Arguments:
#   - some_path: The base directory to start the search for .java files.
# Returns:
#   - A list of .java files (including files in subdirectories) separated by newline.
find_java_files() {
  local base_dir="$1"

  # Check if the directory exists
  if [ ! -d "$base_dir" ]; then
    echo "Error: Directory '$base_dir' not found."
    return 1
  fi

  # Find all .java files in the directory and its subdirectories
  find "$base_dir" -type f -name "*.java"
}

# Function to check if a command is available
check_command() {
  command -v "$1" >/dev/null 2>&1
}

# Check if Google Java Format .jar file exists.
if [ ! -f "$JAR_FILEPATH" ]; then
  # Check if WGET is installed, if not, install it.
  if ! check_command "wget"; then
    if check_command "apt-get"; then
      sudo apt-get update
      sudo apt-get install -y wget
    elif check_command "yum"; then
      sudo yum install -y wget
    else
      echo "Cannot install wget. Please install it manually and rerun the script."
      exit 1
    fi
  fi

  # Download the Google Java Format .jar file using wget
  wget -O "$JAR_FILEPATH" "$JAR_URL"

fi

# Verify the md5 of the file
expected_md5="a76d8e5c461366d908be9d3232a22681"
actual_md5=$(md5sum "$JAR_FILEPATH" | awk '{print $1}')

if [ "$actual_md5" != "$expected_md5" ]; then
  echo "MD5 verification failed. The downloaded file may be corrupted."
  exit 1
fi

chmod +x "$JAR_FILEPATH"
if [[ "$ALL_IN_DIR" == "--all-in-dir" ]]; then
  if [[ "$TARGET_DIR" == "" ]]; then
    echo "Target dir not specified."
    exit 1
  else
    FILELIST="$(find_java_files "$TARGET_DIR")"
    echo "FILELIST=$FILELIST"
    # Use the 'read' command to iterate over the file list
    # The 'IFS' (Internal Field Separator) is set to newline to handle filenames
    # with spaces correctly
    IFS=$'\n'
    for FILEPATH in $FILELIST; do
      echo "Processing file: $FILEPATH"
      java -jar "$JAR_FILEPATH" --replace "$FILEPATH"
    done
  fi
else
  # Only run on the changed files.
  # FILELIST=$(git diff --cached --name-only --diff-filter=ACMR | grep ".*java$")

  # Pre-commit calls this script once per file, so instead of running on all
  # staged files each time, just run on the one pre-commit asks.
  for FILEPATH in "${JAVA_FILEPATH_TO_FORMAT[@]}"; do
    echo "Processing file: $FILEPATH"
    java -jar "$JAR_FILEPATH" --replace "$FILEPATH"
  done
fi
