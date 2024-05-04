import { useEffect, useState } from "react";

export function useQuery(fetcher, trigger = false, args) {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const fetchData = async (args) => {
        setLoading(true);
        try {
            const responseData = await fetcher(args);
            setData(responseData);
            setError(null);
        } catch (error) {
            setError(error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        if (trigger) {
            fetchData(args);
        }
    }, [fetcher]);

    return { data, error, loading, fetch: fetchData };
}