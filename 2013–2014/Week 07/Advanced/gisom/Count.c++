/**
 *The blank Count constructor which empties out Count.
 *
 */

template <typename T>
Count<T>::Count()
{

}

/**
 * The Count copy constructor that holds the amount of times the item has been counted along with what item is equal to of type T.
 * @param item The type T item
 * @param count The amount of times it is counted.
 */

template <typename T>
Count<T>::Count(T t)
{
	item = t;
	count = 1;
}

/**
 * Increments the count by one.
 */

template <typename T>
void Count<T>::increment()
{
	count++;
}

/**
 * returns the item
 *
 * @return item
 */

template <typename T>
T Count<T>::getItem()
{
	return item;
}

/**
 *returns count
 8
 * @return count
 */

template <typename T>
int Count<T>::getCount()
{
	return count;
}


