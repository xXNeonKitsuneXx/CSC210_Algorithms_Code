function search(pattern) {
    var puzzle2D = document.getElementById("puzzleTable");
    height = puzzle2D.rows.length;
    width = puzzle2D.rows[0].cells.length;
    patternLength = pattern.length;
    // alert("Height: " + height + " | Width: " + width + " | Pattern: " + pattern)
    foundAt = "Not found";
    for (let row = 0 ; row < height ; row++){
        for (let column = 0; column < width ; column++) {
            //Case 1 from left to right
            if (column <= width - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row].cells[column + j].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Right";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 2 from right to left
            if (column >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row].cells[column - j].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Left";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 3 from top to bottom
            if (row <= height - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Bottom";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 4 from bottom to top
            if (row >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Top";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 5 from current to top-right
            if (row >= patternLength - 1 && column <= width - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column + 1].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Top-Right";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 6 from current to bottom-right
            if (row <= height - patternLength && column <= width - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column + 1].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Bottom-Right";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 7 from current to top-left
            if (row >= patternLength - 1 && column >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column - j].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Top-Left";
                    break;
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Case 8 from current to bottom-left
            if (row <= height - patternLength && column >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column - j].innerHTML) {
                    j++;
                }
                if ( j == patternLength) {
                    foundAt = "[" + row + "," + column + "] to the Bottom-Left";
                    break;
                }
            }


        }

        if (foundAt != "Not found") {
            break;
        }
    }
    alert(foundAt)
}