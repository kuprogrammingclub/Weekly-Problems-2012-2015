# Week 5

## Beginner 

Everyone knows that you can add (that is, concatenate) two lists together, but what about subtracting two lists? Let's implement a list subtraction program. The program should take two list arguments and remove all values from the first list that are present in the second list. For example,

    > [1,2] [1]
    [2]
    > [7,8,8,8,8,9] [8]
    [7,9]
    > [1,2,3] [3,4,5]
    [1,2]

## Advanced

A [Sierpinski triangle](http://en.wikipedia.org/wiki/Sierpinski_triangle) is a famous type of fractal that dates back to at least the 13th century. It can be thought of as triangles nested within triangles nested within triangles nested in... well, as many levels of triangles as you want.

Create a program which generates a Sierpinski triangle with a certain nested triangle depth. For example,

```
> 0
*
> 1
 *
* *
> 2
   *  
  * * 
 *   *
* * * *
> 3
       *      
      * *     
     *   *    
    * * * *   
   *       *  
  * *     * * 
 *   *   *   *
* * * * * * * *
> 4
               *              
              * *             
             *   *            
            * * * *           
           *       *          
          * *     * *         
         *   *   *   *        
        * * * * * * * *       
       *               *      
      * *             * *     
     *   *           *   *    
    * * * *         * * * *   
   *       *       *       *  
  * *     * *     * *     * * 
 *   *   *   *   *   *   *   *
* * * * * * * * * * * * * * * *
```

Keep in mind that your output need not be formatted exactly like this. If it's more convenient, you can output the triangle from a different perspective. For example,

```
> 3
*
* *
*   *
* * * *
*       *
* *     * *
*   *   *   *
* * * * * * * *
```