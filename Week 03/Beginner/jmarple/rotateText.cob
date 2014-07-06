identification division.
program-id. rotateText.
data division.
working-storage section.
01 StringsSetup.
	02 ValOne pic X(10).
	02 ValTwo pic X(10).
	02 ValThree pic X(100).
01 InputNum pic 9(3) VALUE 0.
procedure division.
begin.

display "Please input the three strings you wish to have rotated."
accept ValOne
accept ValTwo
accept ValThree
perform until InputNum > LENGTH ValOne
	display ValOne(InputNum:1) " " ValTwo(InputNum:1) " " ValThree(InputNum:1)
	add 1 to InputNum
end-perform

stop run.
