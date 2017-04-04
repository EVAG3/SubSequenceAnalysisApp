# SubSequenceAnalysisApp
@ author Yu
The application read the file and analyze the increasing and decreasing subarray.

For the input:
The input file has two lines.
The first line is two integer, N and K. 
The second line is N positive integers of average home sale price, each less than 1,000,000.

For the output
The application return the sum of increasing subarray and decreasing subarray. The result will be printed to console.

How the application works:
The application design start from the worst case. That is the whole array is an increasing/decreasing array.
Then originally I think of DP. I think of the idea to use count[i] to store the longest increasing and decreasing sub array that end at array[i]. Then I consider finish the design for DP in two direction. So I have countLeft and countRight to indicate the subarray start from left/right direction. Then the problem is very simple, it is like a sliding window. I only need to add countLeft[end] and minus countRight[start].

Time complexity and extra space:
Originally, the time complexity is O(K(N-K)) if we try to iterate it. The worest case for O(K(N-K)) is O(N^2). Now the time complexity is O(N). The worst case could be finished in 1.2 second with single process.
The extra space used is O(N). Here 200,000 * 3 int would count up to around 2.4 MB consider int is 4 bytes. 
So 1.2 second is much below 30 second and 1.2 MB is much below 50 MB.

