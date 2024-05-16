

export async function updateCategory(category) {
    const { id, name, description } = category;
    const url = `/api/categories/${id}`;
    
    try {
        const response = await fetch(url, {
            method: 'PUT', // Assuming you're updating an existing resource
            headers: {
                'Content-Type': 'application/json',
                // Add any other headers if needed
            },
            body: JSON.stringify({ name, description }), // Assuming 'category' is an object containing the updated data
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

    } catch (error) {
        console.error('Error updating category:', error);
        throw error; // Propagate the error to the caller
    }
}

export async function fetchCategories() {
    try {
        const response = await fetch('/api/categories');

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching categories:', error);
        throw error;
    }
}

export async function deleteCategory(id) {
    const url = `/api/categories/${id}`;

    try {
        const response = await fetch(url, {
            method: 'DELETE', // Using the DELETE HTTP method to delete the resource
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

    } catch (error) {
        console.error('Error deleting category:', error);
        throw error; // Propagate the error to the caller
    }
}
