class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.presum = [[0] * (len(matrix[0]) + 1) for x in range(len(matrix) + 1)]
        for i, j in product(range(len(matrix)), range(len(matrix[0]))):
            self.presum[i+1][j+1] = matrix[i][j] + self.presum[i][j+1] + self.presum[i+1][j] - self.presum[i][j]
                

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.presum[row2 + 1][col2 + 1] - self.presum[row1][col2 + 1] - self.presum[row2 + 1][col1] + self.presum[row1][col1]  


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)