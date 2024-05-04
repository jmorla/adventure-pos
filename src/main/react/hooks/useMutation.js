import { useState } from "react";


export default function useMutation(func) {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const mutate = async (...args) => {
        setLoading(true);
        try {
            const responseData = await func(...args);
            if (responseData != null) {
                setData(responseData);
            }
            setError(null);
        } catch (error) {
            setError(error);
        } finally {
            setLoading(false);
        }
    };

    return { data, error, loading, mutate };
}