

export async function fetchProducts(request) {
    const { page, size, query } = request;

    const params = new URLSearchParams();
    params.append("page", page);
    params.append("size", size);
    if (query) {
        params.append("query", query);
    }

    const url = `/api/products?${params.toString()}`

    try {
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching products:', error);
        throw error;
    }
}