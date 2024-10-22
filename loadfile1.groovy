def checkChangedFilesAndRunScripts() {
    def changedFiles = sh(script: "git diff --name-only HEAD^ HEAD", returnStdout: true).trim().split("\n")
    for (file in changedFiles) {
        echo "Tệp đã thay đổi: ${file}"
        // Kiểm tra xem tệp nằm trong thư mục A
        if (file.startsWith("A/")) { // Thay đổi này sẽ kiểm tra xem tệp nằm trong thư mục A
            echo "Tệp trong thư mục A đã thay đổi, chạy a.sh"
            sh 'A/a.sh'
        } else if (file.startsWith("B/")) { // Tương tự cho thư mục B
            echo "Tệp trong thư mục B đã thay đổi, chạy b.sh"
            sh 'B/b.sh'
        }
    }
}

return this
